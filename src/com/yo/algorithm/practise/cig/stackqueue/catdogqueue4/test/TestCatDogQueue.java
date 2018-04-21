package com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.test;

import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity.Cat;
import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.structure.CatDogQueueAnother;
import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity.Dog;
import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity.Pet;

/**
 * 测试 -- 猫狗队列
 */
public class TestCatDogQueue {

    public static void main(String[] args) {
        CatDogQueueAnother catDogQueue = new CatDogQueueAnother();
        initCatDogQueue(catDogQueue);
        System.out.println("pollDog : " + catDogQueue.pollDog());
        System.out.println("pollCat : " + catDogQueue.pollCat());
        System.out.println("isEmpty : " + catDogQueue.isEmpty());
        System.out.println("totalSize : " + catDogQueue.totalSize());
        System.out.println("isDogEmpty : " + catDogQueue.isDogEmpty());
        System.out.println("dogSize : " + catDogQueue.dogSize());
        System.out.println("isCatEmpty : " + catDogQueue.isCatEmpty());
        System.out.println("catSize : " + catDogQueue.catSize());
        initCatDogQueue(catDogQueue);
        System.out.println("pollCat : " + catDogQueue.pollCat());
        System.out.println("isEmpty : " + catDogQueue.isEmpty());
        System.out.println("totalSize : " + catDogQueue.totalSize());
        System.out.println("isDogEmpty : " + catDogQueue.isDogEmpty());
        System.out.println("dogSize : " + catDogQueue.dogSize());
        System.out.println("isCatEmpty : " + catDogQueue.isCatEmpty());
        System.out.println("catSize : " + catDogQueue.catSize());
        System.out.println("pollAll : " + catDogQueue.pollAll());
        initCatDogQueue(catDogQueue);
        System.out.println("pollAll : " + catDogQueue.pollAll());
    }

    public static void initCatDogQueue(CatDogQueueAnother catDogQueue) {
        Pet[] petArr = {new Cat(), new Dog(), new Dog(), new Cat(), new Dog(), new Cat(), new Cat(), new Dog()};
        for (Pet pet : petArr) {
            catDogQueue.add(pet);
        }
        System.out.println("init catDogQueue complete");;
    }
}
