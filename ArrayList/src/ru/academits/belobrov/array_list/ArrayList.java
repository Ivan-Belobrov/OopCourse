package ru.academits.belobrov.array_list;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] elements;
    private int size;
    private int modCount;

    public ArrayList() {
        //noinspection unchecked
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость списка не может быть отрицательной. Переданное значение: " + capacity);
        }

        //noinspection unchecked
        elements = (E[]) new Object[capacity];
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
        return indexOf(o) >= 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(elements, 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(E element) {
        add(size, element);
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс должен быть в диапазоне от 0 до " + size + ". Переданный индекс: " + index);
        }

        if (size == elements.length) {
            increaseCapacity();
        }

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
        modCount++;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if (index != -1) {
            remove(index);
            return true;
        }

        return false;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        E removedElement = elements[index];
        int elementsToMoveCount = size - index - 1;

        if (elementsToMoveCount > 0) {
            System.arraycopy(elements, index + 1, elements, index, elementsToMoveCount);
        }

        elements[size - 1] = null;
        size--;
        modCount++;
        return removedElement;
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
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс должен быть в диапазоне от 0 до " + size + ". Переданный индекс: " + index);
        }

        if (collection.isEmpty()) {
            return false;
        }

        ensureCapacity(size + collection.size());
        int elementsToMoveCount = size - index;

        if (elementsToMoveCount > 0) {
            System.arraycopy(elements, index, elements, index + collection.size(), elementsToMoveCount);
        }

        int i = index;

        for (E element : collection) {
            elements[i] = element;
            i++;
        }

        size += collection.size();
        modCount++;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }

        boolean isModified = false;

        for (int i = size - 1; i >= 0; i--) {
            if (collection.contains(elements[i])) {
                remove(i);
                isModified = true;
            }
        }

        return isModified;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            clear();
            return true;
        }

        boolean isModified = false;

        for (int i = size - 1; i >= 0; i--) {
            if (!collection.contains(elements[i])) {
                remove(i);
                isModified = true;
            }
        }

        return isModified;
    }

    @Override
    public void clear() {
        if (size == 0) {
            modCount++;
            return;
        }

        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);

        E oldElement = elements[index];
        elements[index] = element;

        return oldElement;
    }

    private void increaseCapacity() {
        elements = Arrays.copyOf(elements, Math.max(1, elements.length * 2));
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(elements[i], o)) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (Objects.equals(elements[i], o)) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        //noinspection ConstantConditions
        return null;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            elements = Arrays.copyOf(elements, minCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс должен быть в диапазоне от 0 до " + (size - 1) + ". Переданный индекс: " + index);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int index;
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public E next() {
            checkForModification();

            if (!hasNext()) {
                throw new NoSuchElementException("Элементы в списке закончились.");
            }

            int currentIndex = index;
            index++;

            return elements[currentIndex];
        }

        private void checkForModification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException("Список был изменен.");
            }
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(elements[i]).append(", ");
        }

        sb.setLength(sb.length() - 2);
        sb.append("]");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ArrayList<?> list = (ArrayList<?>) o;

        if (size != list.size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!Objects.equals(elements[i], list.elements[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {

        final int HASH_MULTIPLIER = 31;

        int hashValue = 1;

        for (int i = 0; i < size; i++) {
            hashValue = HASH_MULTIPLIER * hashValue + (elements[i] == null ? 0 : elements[i].hashCode());
        }

        return hashValue;
    }
}