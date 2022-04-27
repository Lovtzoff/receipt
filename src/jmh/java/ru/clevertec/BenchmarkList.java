package ru.clevertec;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Для тестирования производительности LinkedList и ArrayList используйте Java Microbenchmark Harness (JMH)
 * 1)	Коллекции должны содержать 100 000 элементов
 * 2)	Проверяем временную сложность следующих методов
 * •	Добавление элемента в начало, середину и конец списка (add(), add(index, element))
 * •	Удаление объекта из списка (remove(element))
 * •	Удаление элемента в начале, середине и конце списка (remove(index))
 * •	Получение элемента по индексу в начале, середине и конце списка (get(index))
 * •	Содержит ли список заданный элемент (contains(element))
 * 3)	Проверить, совпали ли Ваши ожидания с результатами тестов.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1)
@Warmup(iterations = 0)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class BenchmarkList {

    private List<String> arrayList = new ArrayList<>();
    private List<String> linkedList = new LinkedList<>();
    @Param({"100000"})
    private int sizeList;
    @Param({"12345"})
    private String element;

    @Setup(Level.Invocation)
    public void setup() {
        for (int i = 0; i < sizeList; i++) {
            arrayList.add(String.valueOf(i));
            linkedList.add(String.valueOf(i));
        }
    }

    @Benchmark
    public void arrayListAddElementToBegin() {
        arrayList.add(0, element);
    }

    @Benchmark
    public void linkedListAddElementToBegin() {
        linkedList.add(0, element);
    }

    @Benchmark
    public void arrayListAddElementToMiddle() {
        arrayList.add(sizeList / 2, element);
    }

    @Benchmark
    public void linkedListAddElementToMiddle() {
        linkedList.add(sizeList / 2, element);
    }

    @Benchmark
    public void arrayListAddElementToEnd() {
        arrayList.add(element);
    }

    @Benchmark
    public void linkedListAddElementToEnd() {
        linkedList.add(element);
    }

    @Benchmark
    public void arrayListRemoveElement() {
        arrayList.remove(element);
    }

    @Benchmark
    public void linkedListRemoveElement() {
        linkedList.remove(element);
    }

    @Benchmark
    public void arrayListRemoveElementAtBegin() {
        arrayList.remove(0);
    }

    @Benchmark
    public void linkedListRemoveElementAtBegin() {
        linkedList.remove(0);
    }

    @Benchmark
    public void arrayListRemoveElementAtMiddle() {
        arrayList.remove(sizeList / 2);
    }

    @Benchmark
    public void linkedListRemoveElementAtMiddle() {
        linkedList.remove(sizeList / 2);
    }

    @Benchmark
    public void arrayListRemoveElementAtEnd() {
        arrayList.remove(sizeList - 1);
    }

    @Benchmark
    public void linkedListRemoveElementAtEnd() {
        linkedList.remove(sizeList - 1);
    }

    @Benchmark
    public void arrayListGetElementAtBegin() {
        arrayList.get(0);
    }

    @Benchmark
    public void linkedListGetElementAtBegin() {
        linkedList.get(0);
    }

    @Benchmark
    public void arrayListGetElementAtMiddle() {
        arrayList.get(sizeList / 2);
    }

    @Benchmark
    public void linkedListGetElementAtMiddle() {
        linkedList.get(sizeList / 2);
    }

    @Benchmark
    public void arrayListGetElementAtEnd() {
        arrayList.get(sizeList - 1);
    }

    @Benchmark
    public void linkedListGetElementAtEnd() {
        linkedList.get(sizeList - 1);
    }

    @Benchmark
    public void arrayListContainsElement() {
        arrayList.contains(element);
    }

    @Benchmark
    public void linkedListContainsElement() {
        linkedList.contains(element);
    }
}
