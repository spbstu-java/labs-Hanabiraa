import java.util.Collection;
import java.util.List;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        OnlyStream cls = new OnlyStream();

        // среднее значение коллекции
        List<Integer> colInts = List.of(4, 6, 20);
        out.println(cls.average(colInts));

        // метод, приводящий все строки в списке в верхний регистр и добавляющий к ним префикс __new__
        List<String> colStrings = List.of("lorem", "ipsum", "dolor");
        out.println(cls.stringFormatter(colStrings));

        // метод, возвращающий список квадратов всех встречающихся только один раз элементов списка;
        List<Integer> colIntsSquares = List.of(4, 4, 3);
        out.println(cls.squareForUniqNums(colIntsSquares));

        // метод, принимающий на вход коллекцию строк и возвращающий все строки,
        // начинающиеся с заданной буквы, отсортированные по алфавиту;
        List<String> colStringsForSort = List.of("lorem", "ipsum", "dolor", "dollar", "design", "downshift");
        char ch = 'd';
        out.println(cls.filteredSortedStrings(colStringsForSort, ch));

        // метод, принимающий на вход коллекцию и возвращающий её последний элемент
        // или кидающий исключение, если коллекция пуста;
        Collection<Integer> colForLastEl1 = List.of(4, 4, 3);
        Collection<Integer> colForLastEl2 = List.of();
        try {
            out.println(cls.lastElement(colForLastEl1));
            out.println(cls.lastElement(colForLastEl2));
        } catch (RuntimeException e) {
            out.println("перехватили исклчюение из-за пустой коллекции из стрима");
        }

        // метод, принимающий на вход массив целых чисел, возвращающий сумму чётных чисел
        // или 0, если чётных чисел нет;
        int[] colWithOddAndEven = {1, 2, 3, 4};
        int[] colWithOdd = {1, 3, 5};
        out.println(cls.sumEvenNums(colWithOddAndEven));
        out.println(cls.sumEvenNums(colWithOdd));

        // метод, преобразовывающий все строки в списке в Map, где первый символ – ключ, оставшиеся – значение;
        Collection<String> collStrForMap = List.of("lorem", "ipsum", "dolor");
        out.println(cls.stringsToMap(collStrForMap));
    }
}