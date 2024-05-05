import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceComparison {

    private static final int ITERATIONS = 10000;

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

    private static long testAddEnd(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long testAddBeginning(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long testGet(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long testRemoveByIndex(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            list.remove(0);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
