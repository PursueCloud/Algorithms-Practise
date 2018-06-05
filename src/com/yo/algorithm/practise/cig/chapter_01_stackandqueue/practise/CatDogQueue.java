package com.yo.algorithm.practise.cig.chapter_01_stackandqueue.practise;

import com.yo.algorithm.practise.cig.chapter_01_stackandqueue.problem_04_catdogqueue.impl.entity.Cat;
import com.yo.algorithm.practise.cig.chapter_01_stackandqueue.problem_04_catdogqueue.impl.entity.Dog;
import com.yo.algorithm.practise.cig.chapter_01_stackandqueue.problem_04_catdogqueue.impl.entity.Pet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路：
 *      1、包装Pet类，构造一个新的数据结果，用于存储Pet对象以及当前Pet对象在队列中的顺序
 *      2、使用两个队列，分别存储猫和狗对象，但具体存储元素为第1步所构造的数据结果
 *      3、出队时，如要分别出队，则分别使用猫队列或狗队列进行出队；如果要按入队顺序出队，则比较猫队列
 *      和狗队列对头元素的顺序（第1步构造的数据结构中又存储），对顺序较小的元素进行出队
 * 解法：
 *      如思路所述
 */
public class CatDogQueue {
    private final Queue<PetNode> catQueue;
    private final Queue<PetNode> dogQueue;
    private static int index;

    public CatDogQueue() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
    }

    public void add(Pet pet) {
        if (pet instanceof Cat) {
            catQueue.add(new PetNode(pet, index++));
        } else {
            dogQueue.add(new PetNode(pet, index++));
        }
    }

    public Pet pollAll() {
        if (isEmpty()) {
            throw new IllegalStateException("catDogQueue is empty!");
        }
        if (!catQueue.isEmpty() && !dogQueue.isEmpty()) {
            if (catQueue.peek().index < dogQueue.peek().index) {
                return catQueue.poll().pet;
            } else {
                return dogQueue.poll().pet;
            }
        } else if (!catQueue.isEmpty()) {
            return catQueue.poll().pet;
        } else {
            return dogQueue.poll().pet;
        }
    }

    public Cat pollCat() {
        if (catQueue.isEmpty()) {
            throw new IllegalStateException("cat queue is empty!");
        }
        return (Cat)catQueue.poll().pet;
    }
    public int catSize() {
        return catQueue.size();
    }
    public boolean isCatEmpty() {
        return catSize() == 0;
    }
    public Dog pollDog() {
        if (dogQueue.isEmpty()) {
            throw new IllegalStateException("dog queue is empty!");
        }
        return (Dog)dogQueue.poll().pet;
    }
    public int dogSize() {
        return dogQueue.size();
    }
    public boolean isDogEmpty() {
        return dogSize() == 0;
    }

    public int totalSize() {
        return catSize() + dogSize();
    }

    public boolean isEmpty() {
        return totalSize() == 0;
    }

    public static class PetNode {
        private final Pet pet;
        private final int index;

        public PetNode(Pet pet, int index) {
            this.pet = pet;
            this.index = index;
        }
    }
}
