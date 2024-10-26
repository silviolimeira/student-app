package com.sl.app.rest;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers);
        int index = Arrays.binarySearch(numbers, 3);
        numbers[index] *= 10;
        System.out.println(Arrays.toString(numbers));

    }
}
