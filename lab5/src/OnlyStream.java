import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OnlyStream {
    public double average(Collection<Integer> collection) {
        return collection.stream()
                .mapToInt(num -> num)
                .average()
                .orElse(0.0);
    }

    public Collection<String> StringFormatter(Collection<String> collection) {
        return collection.stream()
                .map(String::toUpperCase)
                .map(str -> "__new__" + str)
                .collect(Collectors.toList());
    }

    public Collection<Integer> SquareForUniqNums(Collection<Integer> collection) {
        return collection.stream()
                .mapToInt(num -> num)
                .filter(num -> Collections.frequency(collection, num) == 1)
                .map(num -> num * num)
                .boxed()
                .collect(Collectors.toList());
    }

    public Collection<String> FilteredSortedStrings(Collection<String> collection, char ch) {
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

    public Integer sumEvenNums(Collection<Integer> collection) {
        return collection.stream()
                .mapToInt(num -> num)
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
