package com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.structure;

import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity.Cat;
import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity.Dog;
import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity.Pet;

import java.util.*;

/**
 * 猫狗队列
 */
public class CatDogQueueAnother {
    private final Queue<Cat> catQueue;
    private int catSeq;
    private final Queue<Integer> catSeqQueue;
    private final Queue<Dog> dogQueue;
    private int dogSeq;
    private final Queue<Integer> dogSeqQueue;

    public CatDogQueueAnother() {
        catQueue = new LinkedList<>();
        catSeqQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
        dogSeqQueue = new LinkedList<>();
    }

    public void add(Pet pet) {
        if (pet instanceof Cat) {
            catQueue.add((Cat)pet);
            catSeq = Math.max(catSeq, dogSeq) + 1;
            catSeqQueue.add(catSeq);
        } else if (pet instanceof Dog) {
            dogQueue.add((Dog)pet);
            dogSeq = Math.max(catSeq, dogSeq) + 1;
            dogSeqQueue.add(dogSeq);
        } else {
            throw new IllegalArgumentException("Unknow pet type : " + pet);
        }
    }

    public List<Pet> pollPetsBySeq() {
        List<Pet> petBySeqList = new ArrayList<>();
        int catFirstSeq = !catSeqQueue.isEmpty() ? catSeqQueue.peek() : -1;
        int dogFirstSeq = !dogSeqQueue.isEmpty() ? dogSeqQueue.peek() : -1;
        //判断是否猫和狗队列里都还有元素，如果有，再判断是猫先入队还是狗先入队
        if (catFirstSeq>0 && dogFirstSeq>0) {
            //catFirstSeq>0 && dogFirstSeq>0(both catQueue and dogQueue are not empty)
            if (catFirstSeq < dogFirstSeq) {
                //猫比狗先入队，则先对猫出队，再对狗出队
                petBySeqList.add(pollOneCat());
                petBySeqList.add(pollOneDog());
            } else {
                //狗比猫先入队，则先对狗出队，再对猫出队
                petBySeqList.add(pollOneDog());
                petBySeqList.add(pollOneCat());
            }
            //递归添加下一对顺序的猫狗集合
            petBySeqList.addAll(pollPetsBySeq());
        } else if (catFirstSeq > 0) {
            //catFirstSeq > 0(catQueue is not empty)，如果只有猫，则将剩余的所有猫出队
            while (!catSeqQueue.isEmpty()) {
                petBySeqList.add(pollOneCat());
            }
        } else if (dogFirstSeq > 0) {
            //dogFirstSeq > 0(dogQueue is not empty)，如果只有狗，则将剩余的所有狗出队
            while (!dogQueue.isEmpty()) {
                petBySeqList.add(pollOneDog());
            }
        } else {
            System.err.println("There is no other elements!");
        }
        return petBySeqList;
    }

    public Collection<Pet> pollAll() {
        List<Pet> pollAllPetList = new ArrayList<>(totalSize());
        pollAllPetList.addAll(pollPetsBySeq());
//        while (!isEmpty()) {
//            pollAllPetList.add(pollOne());
//        }
        return pollAllPetList;
    }

    public Collection<Cat> pollCat() {
        List<Cat> pollCatList = new ArrayList<>(catQueue.size());
        while (!catQueue.isEmpty()) {
            pollCatList.add(pollOneCat());
        }
        return pollCatList;
    }

    public Collection<Dog> pollDog() {
        List<Dog> pollDogList = new ArrayList<>(dogQueue.size());
        while (!dogQueue.isEmpty()) {
            pollDogList.add(pollOneDog());
        }
        return pollDogList;
    }

    public Pet pollOne() {
        int catFirstSeq = !catSeqQueue.isEmpty() ? catSeqQueue.peek() : -1;
        int dogFirstSeq = !dogSeqQueue.isEmpty() ? dogSeqQueue.peek() : -1;
        //判断是否猫和狗队列里都还有元素，如果有，再判断是猫先入队还是狗先入队
        if (catFirstSeq>0 && dogFirstSeq>0) {
            //catFirstSeq>0 && dogFirstSeq>0(both catQueue and dogQueue are not empty)
            //下面四处猫狗元素出队不再需要对catSeqQueue和dogSeqQuque再出队，因为前面已经取出了，否则会出现漏数
            if (catFirstSeq < dogFirstSeq) {
                //猫比狗先入队，则对猫出队
                return pollOneCat();
            } else {
                //狗比猫先入队，则对狗出队
                return pollOneDog();
            }
        } else if (catFirstSeq > 0) {
            //catFirstSeq > 0(catQueue is not empty)，如果只有猫，则将剩余的所有猫出队
            return pollOneCat();
        } else if (dogFirstSeq > 0) {
            //dogFirstSeq > 0(dogQueue is not empty)，如果只有狗，则将剩余的所有狗出队
            return pollOneDog();
        } else {
            throw new IllegalStateException("Queue is empty!");
        }
    }


    public Cat pollOneCat() {
        catSeqQueue.poll();
        Cat cat = catQueue.poll();
        return cat;
    }
    public Dog pollOneDog() {
        dogSeqQueue.poll();
        Dog dog = dogQueue.poll();
        return dog;
    }

    public int totalSize() {
        return catQueue.size() + dogQueue.size();
    }

    public int catSize() {
        return catQueue.size();
    }
    public int dogSize() {
        return dogQueue.size();
    }

    public boolean isEmpty() {
        return totalSize() == 0;
    }

    public boolean isCatEmpty() {
        return catQueue.size() == 0;
    }

    public boolean isDogEmpty() {
        return dogQueue.size() == 0;
    }
}
