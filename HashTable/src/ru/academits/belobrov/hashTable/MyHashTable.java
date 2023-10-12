package ru.academits.belobrov.hashTable;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private final Object[] table;
    private int size;

    public MyHashTable(int capacity) {
        this.table = new Object[capacity];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public Object[] getTable() {
        return table;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object element : table) {
            if (element != null && element.equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                return (T) table[currentIndex++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(table, 0, result, 0, size);

        return result;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            return (T1[]) toArray();
        }

        System.arraycopy(table, 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(T t) {
        if (size < table.length) {
            table[size++] = t;
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (table[i] != null && table[i].equals(o)) {
                if (i != size - 1) {
                    table[i] = table[size - 1];
                }

                table[size - 1] = null;
                size--;

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;

        for (T element : c) {
            if (add(element)) {
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        for (Object element : c) {
            if (remove(element)) {
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;

        for (int i = 0; i < size; i++) {
            if (!c.contains(table[i])) {
                remove(table[i]);
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            table[i] = null;
        }

        size = 0;
    }
}