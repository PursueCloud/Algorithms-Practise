package com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity;

public class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + "@" + hashCode();
    }
}
