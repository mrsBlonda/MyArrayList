package org.example;


import org.example.Sort.Sort;

import java.util.ArrayList;

/**
 * author Prokhvataeva Anna
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(19);
        myArrayList.add(2);
        myArrayList.add(34);
        myArrayList.add(4);
        myArrayList.add(55);
        myArrayList.add(6);
        myArrayList.add(10);
        myArrayList.set(2, 90);

        myArrayList.display();
        Sort.quicksort(myArrayList, 0, myArrayList.size() - 1);
        myArrayList.display();
        System.out.println("\nРазмер массива: " + myArrayList.size());
    }
}

