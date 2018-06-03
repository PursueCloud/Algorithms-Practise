package com.yo.algorithm.practise.cig.chapter_01_stackqueue.problem_04_catdogqueue.impl.entity;

public class Pet {
    public static int instanceCnt;
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
