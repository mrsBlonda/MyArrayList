package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    MyArrayList<Object> myArrayList;
    int count1 = 12345;
    int count2 = 98765;
    int count3 = 00000;
    int count4 = 11111;
    int capacity = 3;

    @BeforeEach
    public void createList() {
        myArrayList = new MyArrayList<>(capacity);
        myArrayList.add(count1);
        myArrayList.add(count2);
        myArrayList.add(count3);
    }

    @Test
    void add() {
        Object[] actual = new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            actual[i] = myArrayList.get(i);
        }
        Object[] expected = new Object[] {count1, count2, count3};
        assertArrayEquals(expected, actual);

    }

    @Test
    void testAdd() {
        myArrayList.add(1, count4);
        Object[] actual = new Object[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            actual[i] = myArrayList.get(i);
        }
        Object[] expected = new Object[] {count1, count4, count2, count3};
        assertArrayEquals(expected, actual);

    }

    @Test
    void get() {
        Object actual = myArrayList.get(1);
        Object expected = count2;
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        myArrayList.remove(1);
        Object[] actual = new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            actual[i] = myArrayList.get(i);
        }
        Object[] expected = new Object[] {count1, count3, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    void clear() {
        myArrayList.clear();
        Object[] actual = new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            actual[i] = myArrayList.get(i);
        }
        Object[] expected = new Object[] {null, null, null};
        assertArrayEquals(expected, actual);
    }

    @Test
    void size() {
        int actual = myArrayList.size();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    void set() {
        myArrayList.set(1, count4);
        Object[] actual = new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            actual[i] = myArrayList.get(i);
        }
        Object[] expected = new Object[]{count1, count4, count3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void isEmpty() {
        boolean actual = myArrayList.isEmpty();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void display() {
        Object[] actual = new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            actual[i] = myArrayList.get(i);
        }
        Object[] expected = new Object[]{count1, count2, count3};
        assertArrayEquals(expected, actual);
    }

}