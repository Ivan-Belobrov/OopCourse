package ru.academits.belobrov.arrayList;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private Object[] elements;
    private int size;

    public ArrayList(int capacity) {
        elements = new Object[capacity];
        size = 0;
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
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            return (T1[]) Arrays.copyOf(elements, size, a.getClass());
        }

        System.arraycopy(elements, 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            ensureCapacity(size + 1);
        }

        elements[size] = t;
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                remove(i);

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object oby : c) {
            if (!contains(oby)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", размер: " + size);
        }

        Object[] arr = c.toArray();
        int numNew = arr.length;

        if (numNew == 0) {
            return false;
        }

        ensureCapacity(size + numNew);
        int numMoved = size - index;

        if (numMoved > 0) {
            System.arraycopy(elements, index, elements, index + numNew, numMoved);
        }

        System.arraycopy(arr, 0, elements, index, numNew);
        size += numNew;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        for (int i = 0; i < size; i++) {
            if (c.contains(elements[i])) {
                remove(i);
                i--;
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;

        for (int i = 0; i < size; i++) {
            if (c.contains(elements[i])) {
                remove(i);
                i--;
                modified = true;
            }
        }

        return modified;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }

        size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        T oldValue = (T) elements[index];
        elements[index] = element;

        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", размер: " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T oldValue = (T) elements[index];
        int numMoved = size - index - 1;

        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }

        elements[--size] = null;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void ensureCapacity(int minCapacity) {
        if (elements.length < minCapacity) {
            int newCapacity = elements.length + (elements.length >> 1);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", размер: " + size);
        }
    }

    private class ArrayListIterator implements ListIterator<T> {
        private int cursor;
        private int lastRet = -1;

        public ArrayListIterator() {
            this(0);
        }

        public ArrayListIterator(int index) {
            cursor = index;
        }

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            int i = cursor;

            if (i >= size) {
                throw new NoSuchElementException("Элемент по индексу не найден: " + i);
            }

            Object[] elementData = ArrayList.this.elements;

            if (i >= elementData.length) {
                throw new ConcurrentModificationException("Одновременная модификация, обнаруженная в индексе: " + i);
            }

            cursor = i + 1;

            return (T) elementData[lastRet = i];
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public T previous() {
            int i = cursor - 1;

            if (i < 0) {
                throw new NoSuchElementException("Элемент по индексу не найден: " + i);
            }

            Object[] elementData = ArrayList.this.elements;

            if (i >= elementData.length) {
                throw new ConcurrentModificationException("Одновременная модификация, обнаруженная в индексе: " + i);
            }
            cursor = i;

            return (T) elementData[lastRet = i];
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException("Нет элемента, который нужно удалить.");
            }

            try {
                ArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException("Обнаружена одновременная модификация при удалении элемента с индексом: " + lastRet);
            }
        }

        @Override
        public void set(T t) {
            if (lastRet < 0) {
                throw new IllegalStateException("Нет элемента для установки.");
            }

            try {
                ArrayList.this.set(lastRet, t);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException("Обнаружена одновременная модификация при удалении элемента с индексом: " + lastRet);
            }
        }

        @Override
        public void add(T t) {
            try {
                int i = cursor;
                ArrayList.this.add(i, t);
                cursor = i + 1;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException("Обнаружена одновременная модификация при добавлении элемента по индексу: " + cursor);
            }
        }
    }
}