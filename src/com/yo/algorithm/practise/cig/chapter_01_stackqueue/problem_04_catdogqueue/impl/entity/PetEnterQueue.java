package com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_04_catdogqueue.impl.entity;

/**
 * 猫狗队列包装类
 */
public class PetEnterQueue {
    private final Pet pet;
    private final long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }
}
