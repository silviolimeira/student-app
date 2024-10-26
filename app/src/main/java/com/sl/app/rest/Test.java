package com.sl.app.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    static List<Integer> numbers = new ArrayList<>();
    public static void main(String[] args) {
        numbers.add(4);
        numbers.add(0,3);
        numbers.add(0,2);
        numbers.add(0, 1);
        System.out.println(numbers);
        int index = Arrays.binarySearch(numbers.toArray(), 3);
        numbers.set(index, numbers.get(index) * 10);
        System.out.println(numbers);

    }
}
