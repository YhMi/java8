package top.yhmi;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

import static top.yhmi.CollectorsAction.menu;

/**
 * ClassName: CollectorsAction2 <br/>
 * Description: <br/>
 * date: 2019/5/22 16:34<br/>
 *
 * @author Administrator<br />
 * @Date: Created in 16:34 2019/5/22
 * @Modified By:
 */
public class CollectorsAction2 {
    public static void main(String[] args) {
        testGroupingByConcurrent();
        testGroupingByConcurrentWithFunctionAndCollector();
        testGroupingByConcurrentWithFunctionAndSupplierAndCollector();
        testJoining();
        testJoiningWithDelimiter();
        testJoiningWithDelimiterAndPrefixAndSuffix();
        testMapping();
        testMaxBy();
        testMinBy();
    }
    private static void testGroupingByConcurrent(){
        System.out.println("testGroupingByConcurrent");
        ConcurrentMap<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testGroupingByConcurrentWithFunctionAndCollector(){
        System.out.println("testGroupingByConcurrentWithFunctionAndCollector");
        ConcurrentMap<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testGroupingByConcurrentWithFunctionAndSupplierAndCollector(){
        System.out.println("testGroupingByConcurrentWithFunctionAndSupplierAndCollector");
        ConcurrentSkipListMap<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, ConcurrentSkipListMap::new, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
    }

    private static void testJoining(){
        System.out.println("testJoining");
        Optional.ofNullable(menu.stream().map(Dish::getName).collect(Collectors.joining()))
                .ifPresent(System.out::println);
    }
    private static void testJoiningWithDelimiter(){
        System.out.println("testJoiningWithDelimiter");
        Optional.ofNullable(menu.stream().map(Dish::getName).collect(Collectors.joining(",")))
        .ifPresent(System.out::println);
    }
    private static void testJoiningWithDelimiterAndPrefixAndSuffix(){
        System.out.println("testJoingWithDelimiterAndPrefixAndSuffix");
        Optional.ofNullable(menu.stream().map(Dish::getName).collect(Collectors.joining(",","Names[","]")))
                .ifPresent(System.out::println);
    }
    private static void testMapping(){
        System.out.println("testMapping");
        Optional.ofNullable(menu.stream().collect(Collectors.mapping(Dish::getName,Collectors.joining(","))))
                .ifPresent(System.out::println);
    }

    private static void testMaxBy(){
        System.out.println("testMaxBy");
       menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testMinBy(){
        System.out.println("testMinBy");
        menu.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }
}
