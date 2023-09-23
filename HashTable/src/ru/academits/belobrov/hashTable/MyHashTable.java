package ru.academits.belobrov.hashTable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashTable<T> implements Collection<T> {
    private final int size;
    private final Object[] table;

    public MyHashTable(int size) {
        this.size = size;
        this.table = new Object[size];
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
        int index = Math.abs(o.hashCode() % size);

        return table[index] != null && table[index].equals(o);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyHashTableIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(table, size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T1> T1[] toArray(T1[] array) {
        if (array.length < size) {
            return (T1[]) Arrays.copyOf(table, size, array.getClass());
        }

        System.arraycopy(table, 0, array, 0, size);

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    @Override
    public boolean add(T element) {
        int index = Math.abs(element.hashCode() % size);

        if (table[index] != null) {
            return false;
        }

        table[index] = element;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        int index = Math.abs(obj.hashCode() % size);

        if (table[index] == null || !table[index].equals(obj)) {
            return false;
        }

        table[index] = null;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;

        for (T element : c) {
            modified |= add(element);
        }

        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        for (Object obj : c) {
            modified |= remove(obj);
        }

        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;

        for (int i = 0; i < size; i++) {
            if (table[i] != null && !c.contains(table[i])) {
                table[i] = null;
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
    }

    private class MyHashTableIterator implements Iterator<T> {
        private int cursor;

        public MyHashTableIterator() {
            cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T) table[cursor++];
            }

            throw new NoSuchElementException();
        }
    }
}