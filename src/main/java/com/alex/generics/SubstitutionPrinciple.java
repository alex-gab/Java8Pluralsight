package com.alex.generics;


import java.util.Arrays;

public final class SubstitutionPrinciple {
    public static void main(String[] args) {
        Integer[] ints = new Integer[12];
        ints[0] = 1;
        Number[] nums = ints;
        nums[1] = 3;
        nums[2] = 3.14;
        System.out.println(Arrays.asList(ints));
    }
}
