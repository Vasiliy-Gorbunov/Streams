import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("Абба", "Виолончель", "Пётр", "Жимолость", "Яхта", "Эдмунд");
        Comparator<String> comparator = (String::compareTo);
        BiConsumer<String, String> biConsumer = (o1, o2) -> System.out.println("Min: " + o1 + " Max: " + o2);

        findMinMax(stream, comparator, biConsumer);

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(100));
        }
        getEvensFromList(list);
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

    public static void getEvensFromList(List<Integer> list) {
        List<Integer> evens = list.stream().filter(i -> i % 2 == 0).toList();
        System.out.println("Количество чётных чисел: " + evens.size());
        evens.forEach(System.out::println);
    }
}
