package com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity;

public class Dog extends Pet {
    private final int currIndex;

    public Dog() {
        super("dog");
        currIndex = instanceCnt++;
    }

    @Override
    public String toString() {
        return "Dog：" + currIndex;
    }
}

