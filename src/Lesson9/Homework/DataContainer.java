package Lesson9.Homework;

import java.util.Arrays;
import java.util.Comparator;

public class DataContainer<T> {
    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public DataContainer() {
        this.data = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(T element) {
        if (size == data.length) {
            expandCapacity();
        }
        data[size] = element;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вышел за пределы диапазона" + "0 - " + size + " : " + index);
        }
        return data[index];
    }

    public void sort(Comparator<? super T> comparator) {//означает, что comparator является объектом типа Comparator, который работает с типом T или его супертипом.
        Arrays.sort(data, 0, size, comparator);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }

    private void expandCapacity() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }
}

