package com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.structure;

import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity.Cat;
import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity.Dog;
import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity.Pet;

import java.util.*;

/**
 * 猫狗队列
 */
public class CatDogQueueStandard {
    private final Queue<Cat> catQueue;
    private int catSeq;
    private final Queue<Integer> catSeqQueue;
    private final Queue<Dog> dogQueue;
    private int dogSeq;
    private final Queue<Integer> dogSeqQueue;

    public CatDogQueueStandard() {
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

    public Pet pollAll() {
        //todo implement poll one pet from the catDogQueue
        return null;

    }

    public Cat pollCat() {
        if (catQueue.isEmpty()) {
            throw new RuntimeException("There is no cat in queue!");
        }
        return catQueue.poll();
    }

    public Dog pollDog() {
        if (dogQueue.isEmpty()) {
            throw new RuntimeException("There is no dog in queue!");
        }
        return dogQueue.poll();
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
