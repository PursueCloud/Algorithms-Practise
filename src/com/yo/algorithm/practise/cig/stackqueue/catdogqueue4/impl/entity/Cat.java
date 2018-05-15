package com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity;

public class Cat extends Pet {
    private final int currIndex;

    public Cat() {
        super("cat");
        currIndex = instanceCnt++;
    }

    @Override
    public String toString() {
        return "Cat：" + currIndex;
    }
}

