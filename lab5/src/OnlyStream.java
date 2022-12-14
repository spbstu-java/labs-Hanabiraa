import java.util.*;
import java.util.stream.Collectors;

public class OnlyStream {
    public double average(List<Integer> collection) {
        return collection.stream()
                .mapToInt(num -> num)
                .average()
                .orElse(0.0);
    }

    public List<String> stringFormatter(List<String> collection) {
        return collection.stream()
                .map(String::toUpperCase)
                .map(str -> "__new__" + str)
                .collect(Collectors.toList());
    }

    public List<Integer> squareForUniqNums(List<Integer> collection) {
        return collection.stream()
                .mapToInt(num -> num)
                .filter(num -> Collections.frequency(collection, num) == 1)
                .map(num -> num * num)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<String> filteredSortedStrings(Collection<String> collection, char ch) {
        return collection.stream()
                .filter(str -> str.startsWith(String.valueOf(ch)))
                .sorted()
                .collect(Collectors.toList());
    }

    public Object lastElement(Collection<?> collection) {
        return collection.stream()
                .reduce((el1, el2) -> el2)
                .orElseThrow(RuntimeException::new);
    }

    public Integer sumEvenNums(int[] collection) {
        return Arrays.stream(collection)
                .filter(num -> num % 2 == 0)
                .sum();
    }

    public Map<String, String> stringsToMap(Collection<String> collection) {
        return collection.stream()
                .collect(Collectors.toMap(
                        key -> key.substring(0, 1),
                        value -> value.substring(1)
                ));
    }
}
