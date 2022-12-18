package org.example;


import java.util.Iterator;

public class MyArrayList<E> implements ArrayListNew<E> {
    /**
     * Поле указывает на количество элементов в массиве
     */
    private int size;
    /**
     * Поле указывает на массив элементов
     */
    private E[] array;

    final static private int DEFAULT_CAPACITY = 10;
    /**
     * Создание конструктора по умолчанию. Размер массива равен 10
     */
    public MyArrayList() {
        this.array = (E[]) new Object[DEFAULT_CAPACITY];
    }
    /**
     * Создание конструктора с указанием размера массива. Обрабатывается исключение IllegalArgumentException,
     * если будет введено значение меньше нуля
     */
    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.array = (E[]) new Object[capacity];
        } else {
            throw new IllegalArgumentException("Введите число больше 0");
        }


    }
    /**
     * Добавление элемента в массив в конец списка.
     */
    @Override
    public boolean add(E e) {
        checkingSize();
        array[size++] = e;
        return true;
    }
    /**
     * Добавление элемента в массив по указанному индексу.
     */

    @Override
    public boolean add(int index, E e) {
        checkingSize();
        E[] temp = array;
        try {
            array = (E[]) new Object[temp.length + 1];
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        System.arraycopy(temp, 0, array, 0, index);
        array[index] = e;
        System.arraycopy(temp, index, array, index + 1, temp.length - index);
        size++;
        return true;
    }

    /**
     * Проверка массива на вместительность элемента. Обрабатывается исключение ClassCastException,
     * если некорректно сработает приведение класса
     */
    private void checkingSize() {
        try {
            if (size == array.length) {
                int newCapacity = (array.length * 3) / 2 + 1;
                E[] temp = array;
                array = (E[]) new Object[newCapacity];
                System.arraycopy(temp, 0, array, 0, temp.length);
            }
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public E get(int index) {
        return array[index];
    }
    /**
     * Удаление элемента по его индексу
     */
    @Override
    public void remove(int index) {
        try {
            E[] temp = array;
            System.arraycopy(temp, 0, array, 0, index);
            int amountAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, array, index, amountAfterIndex);
            size--;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
    /**
     * Очищение всего списка.
     */
    @Override
    public void clear() {
        E[] temp = array;
        try {
            array = (E[]) new Object[temp.length];
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
    }
    /**
     * Возвращает размер списка (количество элементов)
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, E e) {
        array[index] = e;
    }

    /**
     * Проверка списка на нахождение в нем хотя бы одного элемента
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Вывод на экран всех элементов
     */
    @Override
    public void display() {
        for (E e : array) {
            if (e != null) {
                System.out.print(" " + e);
            } else {
                break;
            }
        }
        System.out.println();
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(array);
    }


}
