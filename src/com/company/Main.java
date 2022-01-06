package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4));
        List<Integer> list1 = new ArrayList<>();

        System.out.println("Изначальный список:" + list.toString());

        for (int i : list) {
            if (i > 0 && i % 2 == 0){
                list1.add(i);
            }
        }
        Collections.sort(list1);
        System.out.println("Отсортированный список:" + list1);
    }
}