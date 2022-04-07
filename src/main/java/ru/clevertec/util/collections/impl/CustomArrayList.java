package ru.clevertec.util.collections.impl;

import ru.clevertec.util.collections.CustomIterator;
import ru.clevertec.util.collections.CustomList;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Реализация листа как массива.
 *
 * @param <E> тип параметра
 */
@SuppressWarnings("unchecked")
public class CustomArrayList<E> implements CustomList<E> {

    /**
     * Массив элементов.
     */
    private E[] elementsArray;

    /**
     * Размер списка.
     */
    private int size;

    /**
     * Константа DEFAULT_CAPACITY.
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * Установлено ли максимальная кол-во элементов.
     */
    private boolean isSetMaxCapacity = false;

    public CustomArrayList() {
        this.elementsArray = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayList(int capacity) {
        this.elementsArray = (E[]) new Object[capacity];
    }

    @Override
    public CustomIterator<E> getIterator() {
        return new ArrayListIterator();
    }

    @Override
    public void setMaxSize(int maxSize) {
        isSetMaxCapacity = true;
        elementsArray = Arrays.copyOf(elementsArray, maxSize);
        while (size != maxSize) {
            --size;
        }
    }

    @Override
    public void add(E e) {
        if (!isSetMaxCapacity) {
            if (size == elementsArray.length) {
                increaseArray();
            }
            elementsArray[size++] = e;
        }
    }

    @Override
    public void add(int index, E e) {
        if (!isSetMaxCapacity) {
            checkIndexForAdd(index);
            if ((index == size) || (size == elementsArray.length)) {
                increaseArray();
            }
            System.arraycopy(elementsArray, index, elementsArray, index + 1, size - index);
            elementsArray[index] = e;
            size++;
        }
    }

    @Override
    public void addAll(CustomList<? extends E> list) {
        E[] tmpArray = (E[]) new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tmpArray[i] = list.get(i);
        }
        addAll(tmpArray);
    }

    @Override
    public void addAll(E[] es) {
        for (E e : es) {
            add(e);
        }
    }

    @Override
    public E set(int index, E e) {
        checkIndex(index);
        E oldElement = get(index);
        elementsArray[index] = e;
        return oldElement;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldElement = get(index);
        System.arraycopy(elementsArray, index + 1, elementsArray, index, size - index - 1);
        --size;
        return oldElement;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementsArray[i] = null;
        }
        size = 0;
    }

    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (elementsArray[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return elementsArray[index];
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementsArray, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void trim() {
        for (int i = 0; i < size; i++) {
            while (elementsArray[i] == null) {
                remove(i);
                if (i == size) {
                    break;
                }
            }
        }
    }

    /**
     * Итератор.
     */
    private class ArrayListIterator implements CustomIterator<E> {

        /**
         * Текущий индекс.
         */
        int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elementsArray[currentIndex++];
        }

        @Override
        public void remove() {
            CustomArrayList.this.remove(currentIndex);
        }

        @Override
        public void addBefore(E e) {
            CustomArrayList.this.add(currentIndex, e);
        }

        @Override
        public void addAfter(E e) {
            CustomArrayList.this.add(currentIndex + 1, e);
        }
    }

    /**
     * Увеличить массив, если в нем закончилось место.
     */
    private void increaseArray() {
        E[] newArray = (E[]) new Object[elementsArray.length * 2];
        System.arraycopy(elementsArray, 0, newArray, 0, size);
        elementsArray = newArray;
    }

    /**
     * Проверка индекса при добавлении новых элементов.
     *
     * @param index индекс
     */
    private void checkIndexForAdd(int index) {
        if ((index < 0) || (index > size)) {
            throw new IndexOutOfBoundsException("Индекс: " + index + " - выходит за пределы списка.");
        }
    }

    /**
     * Проверка индекса.
     *
     * @param index индекс
     */
    private void checkIndex(int index) {
        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException("Индекс: " + index +
                    " - выходит за пределы списка, либо равен длине списка = " + size);
        }
    }
}
