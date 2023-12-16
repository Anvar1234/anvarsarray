package org.example.anvarsarray.impl;

import org.example.anvarsarray.AnvarsList;

import java.util.Iterator;

public class AnvarsArray<T> implements AnvarsList<T> {

    private T[] defaultArray;

    private final int capacity = 5;
    public int size;

    @SuppressWarnings("unchecked")
    public AnvarsArray() {
        this.size = 0; //так вынести инициализацию части полей ДО try норм?
        try {
            this.defaultArray = (T[]) new Object[capacity];
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(T t) {
        try {
            defaultArray[size] = t;
            size++;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public T[] mergeSort(T[] inputArray) {
        return inputArray; //заглушка
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(defaultArray[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    int index = 0;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return index < defaultArray.length;
            }

            @Override
            public T next() {
                return defaultArray[index++];
            }
        };
    }
}
