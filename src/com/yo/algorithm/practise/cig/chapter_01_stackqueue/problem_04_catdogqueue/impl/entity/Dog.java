package com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_04_catdogqueue.impl.entity;

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

