package com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_04_catdogqueue.impl.structure;

import com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_04_catdogqueue.impl.entity.Cat;
import com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_04_catdogqueue.impl.entity.Dog;
import com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_04_catdogqueue.impl.entity.Pet;
import com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_04_catdogqueue.impl.entity.PetEnterQueue;

import java.util.*;

/**
 * 猫狗队列
 */
public class CatDogQueueStandard {
    private final Queue<PetEnterQueue> catQueue;
    private final Queue<PetEnterQueue> dogQueue;
    private long count;

    public CatDogQueueStandard() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
    }

    public void add(Pet pet) {
        if (pet instanceof Cat) {
            catQueue.add(new PetEnterQueue(pet, count++));
        } else if (pet instanceof Dog) {
            dogQueue.add(new PetEnterQueue(pet, count++));
        } else {
            throw new IllegalArgumentException("Unknown pet type : " + pet.getType());
        }
    }

    public Pet pollAll() {
        //获取猫队列和狗队列队头元素count属性值，如果某一队列为空，其对应count值为-1
        long catSeq = !catQueue.isEmpty() ? catQueue.peek().getCount() : -1;
        long dogSeq = !dogQueue.isEmpty() ? dogQueue.peek().getCount() : -1;
        if (catSeq>0 && dogSeq>0) {
            //如果猫队列和狗队列均不为空
            if (catSeq < dogSeq) {
                //猫元素入队顺序比狗队列顺序小，对猫队列进行出队
                return catQueue.poll().getPet();
            } else {
                //否则对狗队列进行出队
                return dogQueue.poll().getPet();
            }
        } else if (catSeq > 0) {
            //仅猫队列不为空，则对猫队列出队
            return catQueue.poll().getPet();
        } else if (dogSeq > 0) {
            //仅狗队列不为空，则对狗队列出队
            return dogQueue.poll().getPet();
        } else {
            //猫队列和狗队列均为空，则抛出异常
            throw new IllegalStateException("Queue is empty!");
        }
    }

    public Cat pollCat() {
        if (catQueue.isEmpty()) {
            throw new RuntimeException("There is no cat in queue!");
        }
        return (Cat)catQueue.poll().getPet();
    }

    public Dog pollDog() {
        if (dogQueue.isEmpty()) {
            throw new RuntimeException("There is no dog in queue!");
        }
        return (Dog) dogQueue.poll().getPet();
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
