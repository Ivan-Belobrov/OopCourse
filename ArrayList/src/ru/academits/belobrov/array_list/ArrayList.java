package ru.academits.belobrov.array_list;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private E[] elements;
    private int size;
    private int modCount = 0;

    public ArrayList(){
        this.size = size();
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость списка не может быть отрицательной. Переданное значения: " + capacity);
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
    public Iterator<E> iterator() {
        return new ArrayListIterator();
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
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
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
            throw new IndexOutOfBoundsException("Индекс " + index + " находится за пределами допустимого диапазона [0, " + size + "]");
        }

        if (collection.isEmpty()) {
            return false;
        }

        ensureCapacity(size + collection.size());
        int elementsToMoveNumber = size - index;

        if (elementsToMoveNumber > 0) {
            System.arraycopy(elements, index, elements, index + collection.size(), elementsToMoveNumber);
        }

        int i = index;

        for (E element : collection) {
            elements[i] = element;
            i++;
        }

        size += collection.size();
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

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            int minIndex = 0;
            int maxIndex = size;
            throw new IndexOutOfBoundsException("Индекс должен быть в диапазоне от " + minIndex + " до " + maxIndex + ". Переданный индекс: " + index);
        }

        ensureCapacity(size + 1);

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedElement = (E) elements[index];
        int elementsToMove = size - index - 1;

        if (elementsToMove > 0) {
            System.arraycopy(elements, index + 1, elements, index, elementsToMove);
        }

        elements[size - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
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
                if (elements[i] == null) {
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
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public void ensureCapacity(int minCapacity) {
        int oldCapacity = elements.length;

        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;

            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }

            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " находится за пределами допустимого диапазона [0, " + (size - 1) + "]");
        }
    }

    private class ArrayListIterator implements Iterator<E> {
        private int currentIndex;
        private int expectedModCount = modCount;
        private boolean removed = false;

        @Override
        public boolean hasNext() {
            return currentIndex != size;
        }

        @Override
        public E next() {
            checkForModification();

            if (!hasNext()) {
                throw new NoSuchElementException("Элемент не найден.");
            }

            int previousIndex = currentIndex;
            currentIndex++;
            removed = false;

            return (E) elements[previousIndex];
        }

        @Override
        public void remove() {
            checkForModification();

            if (currentIndex <= 0 || removed) {
                throw new IllegalStateException("Нет элемента, который нужно удалить.");
            }

            expectedModCount++;
            removed = true;
        }

        private void checkForModification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException("Список был модифицирован.");
            }
        }
    }
}