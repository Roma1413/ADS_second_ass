package org.classess;

public class MyArrayList<E> implements MyList<E> {
    private Object[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public MyArrayList() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(E element) {
        ensureCapacity();
        data[size++] = element;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) data[index];
    }

    public void set(int index, E element) {
        checkIndex(index);
        data[index] = element;
    }

    public E remove(int index) {
        checkIndex(index);
        E removed = (E) data[index];
        for (int i = index; i < size - 1; i++)
            data[i] = data[i + 1];
        data[--size] = null;
        return removed;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public void clear() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++)
                newData[i] = data[i];
            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);
    }

    public java.util.Iterator<E> iterator() {
        return new java.util.Iterator<E>() {
            int cursor = 0;
            public boolean hasNext() { return cursor < size; }
            public E next() { return (E) data[cursor++]; }
        };
    }
}