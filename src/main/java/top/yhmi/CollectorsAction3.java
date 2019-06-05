package top.yhmi;

/**
 * ClassName: CollectorsAction3 <br/>
 * Description: <br/>
 * date: 2019/5/27 15:41<br/>
 *
 * @author Administrator<br />
 * @Date: Created in 15:41 2019/5/27
 * @Modified By:
 */

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static top.yhmi.CollectorsAction.menu;

public class CollectorsAction3 {
    public static void main(String[] args) {
        testPartitioningByWithPredicate();
        testPartitionByWithPredicateAndCollector();
        testReducingBinaryOperator();
        testReducingBinaryOperatorAndIdentiy();
        testReducingVBinaryOperatorAndIdentiyAndFunction();
        testSumarizingDouble();
        testSumarizingLong();
        testSumarizingInt();
    }

    private static void testPartitioningByWithPredicate() {
        System.out.println("testPartitioningByWithPredicate");
        Map<Boolean, List<Dish>> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testPartitionByWithPredicateAndCollector() {
        System.out.println("testPartitionByWithPredicateAndCollector");
        Map<Boolean, Double> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperator() {
        System.out.println("testReducingBinaryOperator");
        menu.stream().collect(
                Collectors.reducing(
                        BinaryOperator.maxBy(
                                Comparator.comparingInt(Dish::getCalories)
                        )
                )).ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperatorAndIdentiy() {
        System.out.println("testReducingBinaryOperatorAndIdentiy");
        Integer result = menu.stream().map(Dish::getCalories).collect(Collectors.reducing(0, (d1, d2) -> d1 + d2));
        Optional.ofNullable(result).ifPresent(System.out::println);
    }

    private static void testReducingVBinaryOperatorAndIdentiyAndFunction() {
        System.out.println("testReducingVBinaryOperatorAndIdentiyAndFunction");
        Integer result = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (d1, d2) -> d1 + d2));
        System.out.println(result);
    }

    private static void testSumarizingDouble() {
        System.out.println("testSumarizingDouble");
        Optional.ofNullable(menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories))).ifPresent(System.out::println);

    }

    private static void testSumarizingLong() {
        System.out.println("testSumarizingLong");
        Optional.ofNullable(menu.stream().collect(Collectors.summarizingLong(Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void testSumarizingInt() {
        System.out.println("testSumarizingInt");
        Optional.ofNullable(menu.stream().collect(Collectors.summarizingInt((Dish::getCalories)))).ifPresent(System.out::println);
    }
}
