import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс {@code ListPerformanceComparison} предназначен для сравнения
 * производительности двух типов списков: {@link ArrayList} и {@link LinkedList}.
 *
 * @author [Zemlyanukhin]
 * @version 1.0
 */
public class ListPerformanceComparison {

    /**
     * Количество итераций для тестирования производительности.
     */
    private static final int ITERATIONS = 10000;

    /**
     * Сравнивает производительность {@code ArrayList} и {@code LinkedList}
     * для операций добавления, удаления и получения элементов.
     *
     * Результаты выводятся в виде таблицы с указанием времени выполнения
     * каждой операции в миллисекундах.
     */
    public static void comparePerformance() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Заполнение списков
        for (int i = 0; i < ITERATIONS; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        System.out.println("Операция\t\tArrayList (мс)\tLinkedList (мс)");
        System.out.println("--------------------------------------------------");

        // Тестирование добавления в конец списка
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            arrayList.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("add (конец)\t\t" + (endTime - startTime) + "\t\t" + testAddEnd(linkedList));

        // Тестирование добавления в начало списка
        startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            arrayList.add(0, i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("add (начало)\t\t" + (endTime - startTime) + "\t\t" + testAddBeginning(linkedList));

        // Тестирование получения элемента по индексу
        startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            arrayList.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("get\t\t\t" + (endTime - startTime) + "\t\t" + testGet(linkedList));

        // Тестирование удаления элемента по индексу
        startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            arrayList.remove(0);
        }
        endTime = System.currentTimeMillis();
        System.out.println("remove (индекс)\t" + (endTime - startTime) + "\t\t" + testRemoveByIndex(linkedList));
    }

    /**
     * Тестирует добавление элементов в конец списка.
     *
     * @param list Список, в который добавляются элементы.
     * @return Время выполнения операции в миллисекундах.
     */
    private static long testAddEnd(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Тестирует добавление элементов в начало списка.
     *
     * @param list Список, в который добавляются элементы.
     * @return Время выполнения операции в миллисекундах.
     */
    private static long testAddBeginning(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Тестирует получение элемента по индексу.
     *
     * @param list Список, из которого получают элемент.
     * @return Время выполнения операции в миллисекундах.
     */
    private static long testGet(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Тестирует удаление элемента по индексу.
     *
     * @param list Список, из которого удаляется элемент.
     * @return Время выполнения операции в миллисекундах.
     */
    private static long testRemoveByIndex(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            list.remove(0);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}