package ru.clevertec.util.collections.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.clevertec.util.collections.CustomIterator;
import ru.clevertec.util.collections.CustomList;

public class CustomArrayListTest {

    private CustomList<Integer> list;
    private int size = 16;

    @Before
    public void setUp() {
        list = new CustomArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    @Test
    public void getIterator() {
        CustomIterator<Integer> iterator = list.getIterator();
        Assert.assertTrue(iterator.hasNext());
        while (iterator.hasNext()) {
            int tmpElement = iterator.next();
            Assert.assertEquals(Integer.valueOf(++tmpElement), iterator.next());
        }
    }

    @Test
    public void getIterator1() {
        CustomIterator<Integer> iterator = list.getIterator();
        while (iterator.hasNext()) {
            int tmpElement = iterator.next();
            if (tmpElement == 3) {
                iterator.addBefore(36);
                Assert.assertEquals(++size, list.size());
            }
            if (tmpElement == 10) {
                iterator.addAfter(45);
                Assert.assertEquals(++size, list.size());
            }
            if (tmpElement == 12) {
                iterator.remove();
                Assert.assertEquals(--size, list.size());
            }
        }
    }

    @Test
    public void setMaxSize() {
        int maxSize = 25;
        CustomList<Integer> oldList = new CustomArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            oldList.add(i);
        }
        list.setMaxSize(maxSize);
        Assert.assertEquals(maxSize, list.size());
        for (int i = 0; i < oldList.size(); i++) {
            Assert.assertEquals(oldList.get(i), list.get(i));
        }
    }

    @Test
    public void add() {
        CustomList<Integer> oldList = new CustomArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            oldList.add(i);
        }
        list.add(33);
        Assert.assertEquals(Integer.valueOf(33), list.get(size));
        Assert.assertEquals(++size, list.size());
        for (int i = 0; i < oldList.size(); i++) {
            Assert.assertEquals(oldList.get(i), list.get(i));
        }
    }

    /**
     * Тест метода add(int index, E e).
     */
    @Test
    public void testAdd() {
        CustomList<Integer> oldList = new CustomArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            oldList.add(i);
        }
        list.add(5, 44);
        Assert.assertEquals(Integer.valueOf(44), list.get(5));
        Assert.assertEquals(++size, list.size());
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(oldList.get(i), list.get(i));
        }
        for (int i = 6; i < list.size(); i++) {
            Assert.assertEquals(oldList.get(i - 1), list.get(i));
        }
    }

    @Test
    public void addAll() {
        CustomList<Integer> oldList = new CustomArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            oldList.add(i);
        }
        CustomList<Integer> tmpList = new CustomArrayList<>();
        for (int i = 0; i < 6; i++) {
            tmpList.add(i);
        }
        list.addAll(tmpList);
        Assert.assertEquals(size += tmpList.size(), list.size());
        for (int i = 0; i < oldList.size(); i++) {
            Assert.assertEquals(oldList.get(i), list.get(i));
        }
        for (int i = oldList.size(); i < list.size(); i++) {
            Assert.assertEquals(tmpList.get(i - oldList.size()), list.get(i));
        }
    }

    /**
     * Тест метода addAll(E[] es).
     */
    @Test
    public void testAddAll() {
        CustomList<Integer> oldList = new CustomArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            oldList.add(i);
        }
        Integer[] array = new Integer[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        list.addAll(array);
        Assert.assertEquals(size += array.length, list.size());
        for (int i = 0; i < oldList.size(); i++) {
            Assert.assertEquals(oldList.get(i), list.get(i));
        }
        for (int i = oldList.size(); i < list.size(); i++) {
            Assert.assertEquals(array[i - oldList.size()], list.get(i));
        }
    }

    @Test
    public void set() {
        int index = 6;
        int oldElement = list.get(index);
        int tmpElement = 78;
        Assert.assertEquals(Integer.valueOf(oldElement), list.set(index, tmpElement));
        Assert.assertEquals(Integer.valueOf(tmpElement), list.get(index));
    }

    @Test
    public void remove() {
        CustomList<Integer> oldList = new CustomArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            oldList.add(i);
        }

        int index = 8;
        int oldElement = list.get(index);
        Assert.assertEquals(Integer.valueOf(oldElement), list.remove(index));
        Assert.assertEquals(oldList.get(index + 1), list.get(index));
    }

    @Test
    public void clear() {
        list.clear();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void find() {
        int element = 11;
        Assert.assertEquals(element, list.find(element));
    }

    @Test
    public void get() {
        int index = 10;
        Assert.assertEquals(Integer.valueOf(index), list.get(index));
    }

    @Test
    public void toArray() {
        CustomList<Integer> oldList = new CustomArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            oldList.add(i);
        }
        Assert.assertEquals(size, list.toArray().length);
        for (int i = 0; i < list.toArray().length; i++) {
            Assert.assertEquals(oldList.get(i), list.toArray()[i]);
        }
    }

    @Test
    public void size() {
        Assert.assertEquals(size, list.size());
    }

    @Test
    public void trim() {
        list.add(null);
        list.add(null);
        list.add(null);
        list.trim();
        Assert.assertEquals(size, list.size());
        for (int i = 0; i < list.size(); i++) {
            Assert.assertNotNull(list.get(i));
        }
    }
}