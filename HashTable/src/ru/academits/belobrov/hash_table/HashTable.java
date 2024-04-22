package ru.academits.belobrov.hash_table;

import java.util.*;

public class HashTable<E> implements Collection<E> {
    private final List<E>[] lists;
    private int size;
    private int modificationsCount;

    private static final int DEFAULT_CAPACITY = 16;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Вместимость должна быть положительным значением, передано: " + capacity);
        }

        //noinspection unchecked
        lists = new ArrayList[capacity];
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

        return lists[index] != null && lists[index].contains(obj);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int listIndex;
            private int elementIndex;
            private int iteratedElementsCount;
            private final int expectedModificationsCount = modificationsCount;

            @Override
            public boolean hasNext() {
                return iteratedElementsCount < size;
            }

            @Override
            public E next() {
                if (modificationsCount != expectedModificationsCount) {
                    throw new ConcurrentModificationException("Коллекция была изменена.");
                }

                if (!hasNext()) {
                    throw new NoSuchElementException("В коллекции больше нет элементов.");
                }

                E element = null;

                while (listIndex < lists.length) {
                    List<E> currentList = lists[listIndex];

                    if (currentList != null && !currentList.isEmpty()) {
                        element = currentList.get(elementIndex);
                        elementIndex++;
                        iteratedElementsCount++;

                        if (elementIndex >= currentList.size()) {
                            listIndex++;
                            elementIndex = 0;
                        }

                        break;
                    }

                    listIndex++;
                }

                return element;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;

        for (List<E> list : lists) {
            if (list != null) {
                for (E element : list) {
                    result[i] = element;
                    i++;
                }
            }
        }

        return result;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(toArray(), size, array.getClass());
        }

        int i = 0;

        for (List<E> list : lists) {
            if (list != null) {
                for (E element : list) {
                    //noinspection unchecked
                    array[i] = (T) element;
                    i++;
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
        int index = getIndex(element);

        if (lists[index] == null) {
            lists[index] = new ArrayList<>();
        }

        lists[index].add(element);
        size++;
        modificationsCount++;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        int index = getIndex(obj);

        if (lists[index] != null && lists[index].remove(obj)) {
            size--;
            modificationsCount++;
            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object element : collection) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }

        for (E element : collection) {
            add(element);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean isModified = false;

        for (Object item : collection) {
            while (remove(item)) {
                isModified = true;
            }
        }

        return isModified;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean isModified = false;

        for (List<E> list : lists) {
            if (list != null) {
                int initialSize = list.size();
                isModified |= list.retainAll(collection);
                size -= initialSize - list.size();
            }
        }

        if (isModified) {
            modificationsCount++;
        }

        return isModified;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            return;
        }

        for (List<E> list : lists) {
            if (list != null) {
                list.clear();
            }
        }

        size = 0;
        modificationsCount++;
    }

    private int getIndex(Object obj) {
        if (obj == null) {
            return 0;
        }

        return Math.abs(obj.hashCode() % lists.length);
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (E element : this) {
            sb.append(element).append(", ");
        }

        int length = sb.length();

        if (length > 1) {
            sb.setLength(length - 2);
        }

        sb.append("]");

        return sb.toString();
    }
}