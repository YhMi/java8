package top.yhmi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class LambdaUsage {
    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple))
                result.add(apple);
        }
        return result;
    }

    private static List<Apple> filterByWight(List<Apple> source, LongPredicate predicate) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple.getWeight()))
                result.add(apple);
        }
        return result;
    }


    private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String, Long> predicate) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple.getColor(), apple.getWeight()))
                result.add(apple);
        }
        return result;
    }

    private static void simpleTestConsumer(List<Apple> source, Consumer<Apple> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple);
        }
    }

    private static void simpleBiConsumer(String c, List<Apple> source, BiConsumer<Apple, String> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple, c);
        }
    }

    private static String testFunction(Apple apple, Function<Apple, String> fun) {
        return fun.apply(apple);
    }

    private static Apple testBiFunction(String color, long weight, BiFunction<String, Long, Apple> fun) {
        return fun.apply(color, weight);
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 120), new Apple("red", 150));
        List<Apple> greenList = filter(list, (apple) -> apple.getColor().equals("green"));
        System.out.println(greenList);

        List<Apple> result = filterByWight(list, (w) -> w > 100);
        System.out.println(result);

        List<Apple> result2 = filterByBiPredicate(list, (s, w) -> s.equals("green") && w > 100);
        System.out.println(result2);

        System.out.println("========================");
        simpleTestConsumer(list, apple -> System.out.println(apple));

        System.out.println("========================");
        simpleBiConsumer("XXX", list, (a, s) -> System.out.println(s + a.getColor() + ":Weight=>" + a.getWeight()));

        System.out.println("========================");
        String result3 = testFunction(new Apple("yellow", 100), Apple::toString);
        System.out.println(result3);

        IntFunction<Double> f = i -> i * 100.0d;
        Double result4 = f.apply(10);
        System.out.println("==========================");
        System.out.println(result4);

        System.out.println("==========================");
        Apple a = testBiFunction("Blue", 130, Apple::new);
        System.out.println(a);

        System.out.println("==========================");
        Supplier<String> s = String::new;
        System.out.println(s.get().getClass());

        Apple a2 = createApple(() -> new Apple("Green", 100));
        System.out.println(a2);



    }

    private static void process(Runnable r) {
        r.run();
    }
    private static Apple createApple(Supplier<Apple> supplier){
        return supplier.get();
    }
}
