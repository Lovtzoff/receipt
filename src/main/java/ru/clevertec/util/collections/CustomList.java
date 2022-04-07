package ru.clevertec.util.collections;

/**
 * Интерфейс пользовательской коллекции.
 *
 * @param <E> тип параметров
 */
public interface CustomList<E> {

    /**
     * Возвращает итератор.
     *
     * @return итератор
     */
    CustomIterator<E> getIterator();

    /**
     * Устанавливает максимальное количество элементов.
     *
     * @param maxSize максимальная длина
     */
    void setMaxSize(int maxSize);

    /**
     * Вставляет новый элемент.
     *
     * @param e элемент
     */
    void add (E e);

    /**
     * Вставляет новый элемент перед элементом, на который указывает индекс.
     *
     * @param index индекс
     * @param e     элемент
     */
    void add (int index, E e);

    /**
     * Вставляет элементы в коллекцию коллекцией того же типа.
     *
     * @param list коллекция
     */
    void addAll(CustomList<? extends E> list);

    /**
     * Вставляет элементы в коллекцию массивом того же типа.
     *
     * @param es массив
     */
    void addAll(E[] es);

    /**
     * Обновляет элемент по индексу, возвращая старый элемент.
     *
     * @param index индекс
     * @param e     новый элемент
     * @return старый элемент
     */
    E set(int index, E e);

    /**
     * Удаляет объект, возвращая старый объект.
     *
     * @param index индекс
     * @return старый элемент
     */
    E remove(int index);

    /**
     * Полностью очищает коллекцию.
     */
    void clear();

    /**
     * Ищет по элементу, возвращая номер позиции, или -1, если такого элемента нет.
     *
     * @param e элемент
     * @return индекс элемента
     */
    int find(E e);

    /**
     * Получает элемент по индексу.
     *
     * @param index индекс
     * @return элемент
     */
    E get(int index);

    /**
     * Преобразует коллекцию в массив объектов.
     *
     * @return массив объектов
     */
    Object[] toArray();

    /**
     * Возвращает количество элементов.
     *
     * @return кол-во элементов
     */
    int size();

    /**
     * Удаляет null-элементы.
     */
    void trim();
}
