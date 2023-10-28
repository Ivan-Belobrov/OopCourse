package ru.academits.belobrov.hashTable;

import java.util.*;

public class MyHashTable<E> implements Collection<E> {
    private final List<E>[] table;
    private int size;
    private int modificationCount;

    public MyHashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть положительным значением.");
        }

        this.table = new ArrayList[capacity];
        this.size = 0;
        this.modificationCount = 0;
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
    public boolean contains(Object obj) {
        int index = getIndex(obj);

        if (table[index] != null) {
            return table[index].contains(obj);
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;
            private final int expectedModificationCount = modificationCount;

            @Override
            public boolean hasNext() {
                checkForModification();
                return currentIndex < size;
            }

            @Override
            public E next() {
                checkForModification();

                if (!hasNext()) {
                    throw new NoSuchElementException("В коллекции больше нет элементов.");
                }

                E element = null;

                for (List<E> list : table) {
                    if (list != null && !list.isEmpty()) {
                        element = list.remove(0);
                        break;
                    }
                }

                currentIndex++;
                return element;
            }

            private void checkForModification() {
                if (modificationCount != expectedModificationCount) {
                    throw new ConcurrentModificationException("Коллекция была изменена.");
                }
            }

        };
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int index = 0;

        for (List<E> list : table) {
            if (list != null) {

                for (E item : list) {
                    result[index++] = item;
                }
            }
        }

        return result;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size) {
            return (T[]) Arrays.copyOf(toArray(), size, array.getClass());
        }

        int index = 0;

        for (List<E> list : table) {
            if (list != null) {
                for (E item : list) {
                    array[index++] = (T) item;
                }
            }
        }

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    @Override
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException("Добавляемый элемент не может быть null.");
        }

        int index = getIndex(element);

        if (table[index] == null) {
            table[index] = new ArrayList<>();
        }

        if (table[index].add(element)) {
            size++;
            modificationCount++;
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(Object obj) {
        int index = getIndex(obj);

        if (table[index] != null && table[index].remove(obj)) {
            size--;
            modificationCount++;
            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object item : collection) {
            if (!contains(item)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean modified = false;

        for (E item : collection) {
            if (add(item)) {
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean modified = false;

        for (Object item : collection) {
            if (remove(item)) {
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean modified = false;

        for (List<E> list : table) {
            if (list != null) {
                modified |= list.retainAll(collection);

                if (list.isEmpty()) {
                    size -= list.size();
                    modificationCount++;
                    list.clear();
                }
            }
        }

        return modified;
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
        modificationCount++;
    }

    public int getIndex(Object obj) {
        if (obj == null) {
            return 0;
        }

        int hash = obj.hashCode();

        return Math.abs(hash % table.length);
    }
}