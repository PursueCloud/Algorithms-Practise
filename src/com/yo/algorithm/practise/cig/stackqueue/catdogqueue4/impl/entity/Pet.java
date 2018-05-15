package com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity;

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
