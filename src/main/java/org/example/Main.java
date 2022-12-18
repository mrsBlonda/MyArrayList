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
//        myArrayList.set(2, 90);
        myArrayList.display();
        System.out.println("После удаления: ");
        myArrayList.remove(1);
        myArrayList.remove(3);
        myArrayList.remove(2);

        myArrayList.display();
        Sort.quicksort(myArrayList, 0, myArrayList.size() - 1);
        System.out.println("После сортировки: ");
        myArrayList.display();

        MyArrayList<Object> objects = new MyArrayList<>();
        for (int i = 0; i < 1000; i++) {
            objects.add(0, new Object());
        }
        objects.display();
        System.out.println("\nРазмер массива: " + myArrayList.size());
        System.out.println("\nРазмер массива: " + objects.size());



    }
}

