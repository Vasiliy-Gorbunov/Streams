import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<String> stream = Stream.of();
        Comparator<String> comparator = (String::compareTo);
        BiConsumer<String, String> biConsumer = (o1, o2) -> System.out.println(o1 + " " + o2);

        findMinMax(stream, comparator, biConsumer);
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> str = stream.collect(Collectors.toList());
        if (str.stream().findAny().isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            T min = str.stream().min(order).get();
            T max = str.stream().max(order).get();
            minMaxConsumer.accept(min, max);
        }
    }
}
