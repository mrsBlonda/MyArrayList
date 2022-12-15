package org.example.Sort;

import org.example.MyArrayList;

public class Sort {
    public static <T extends Comparable<T>> void quicksort(MyArrayList<T> list, int a, int b) {
        if (a < b) {
            int i = a, j = b;
            T x = list.get((i + j) / 2);

            do {
                while (list.get(i).compareTo(x) < 0) i++;
                while (x.compareTo(list.get(j)) < 0) j--;

                if (i <= j) {
                    T tmp = list.get(i);
                    T jTemp = list.get(j);
                    list.set(i, jTemp);
                    list.set(j, tmp);
                    i++;
                    j--;
                }

            } while (i <= j);

            quicksort(list, a, j);
            quicksort(list, i, b);
        }
    }


}

