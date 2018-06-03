package com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_04_catdogqueue.impl.entity;

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

