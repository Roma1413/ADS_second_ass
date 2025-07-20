package org.clasess;

public interface MyList<E> extends Iterable<E> {
    void add(E element);
    E get(int index);
    void set(int index, E element);
    E remove(int index);
    int size();
    boolean isEmpty();
    void clear();
}
