package org.example;

public interface ArrayListNew<E> extends Iterable<E> {
    boolean add(E e);

    boolean add(int index, E e);

    E get(int index);

    void remove(int index);

    void clear();

    int size();

    void set(int index, E e);

    boolean isEmpty();
    void display();


}
