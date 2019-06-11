package top.yhmi;

/**
 * ClassName: CollectorsAction4 <br/>
 * Description: <br/>
 * date: 2019/6/5 9:41<br/>
 *
 * @author Administrator<br />
 * @Date: Created in 9:41 2019/6/5
 * @Modified By:
 */

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

import static top.yhmi.CollectorsAction.menu;

public class CollectorsAction4 {
    public static void main(String[] args) {
        testSummingDouble();
        testSummingLong();
        testSummingInt();
        testToCollection();
        testToConcurrentMap();
        testTocurrentMapWithBinaryOperator();
        testToConcurrentMapWithBinaryOperatorAndSupplier();
        testToList();
        testToSet();
        testToMap();
        testToMapWithBinaryOperator();
        testToMapWithBinaryOperatorAndSupplier();
    }

    private static void testSummingDouble() {
        System.out.println("testSummingDouble");
        Optional.of(menu.stream().collect(Collectors.summingDouble(Dish::getCalories)))
                .ifPresent(System.out::println);
        Optional.of(menu.stream().map(Dish::getCalories).mapToInt(Integer::intValue).sum())
                .ifPresent(System.out::println);
    }

    private static void testSummingLong() {
        System.out.println("testSummingLong");
        Optional.of(menu.stream().collect(Collectors.summingLong(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testSummingInt() {
        System.out.println("testSummingInt");
        Optional.of(menu.stream().collect(Collectors.summingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testToCollection() {
        System.out.println("testToCollection");
        Optional.of(menu.stream().filter(dish -> dish.getCalories() > 600).collect(Collectors.toCollection(LinkedList::new)))
                .ifPresent(System.out::println);
    }

    private static void testToConcurrentMap() {
        System.out.println("testToConcurrentMap");
        Optional.of(menu.stream().collect(Collectors.toConcurrentMap(Dish::getName, Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    /**
     * Type:Total
     */
    private static void testTocurrentMapWithBinaryOperator() {
        System.out.println("testTocurrentMapWithBinaryOperator");
        Optional.of(menu.stream()
                .collect(Collectors.toConcurrentMap(Dish::getType, v -> 1L, (a, b) -> a + b)))
                .ifPresent(v -> {
                    System.out.println(v);
                    System.out.println(v.getClass());
                });
    }

    private static void testToConcurrentMapWithBinaryOperatorAndSupplier() {
        System.out.println("testToConcurrentMapWithBinaryOperatorAndSupplier");
        Optional.of(menu.stream().collect(Collectors.toConcurrentMap(Dish::getType, v -> 1L, (a, b) -> a + b, ConcurrentSkipListMap::new)))
                .ifPresent(v -> {
                    System.out.println(v);
                    System.out.println(v.getClass());
                });
    }

    private static void testToList() {
        System.out.println("testToList");
        Optional.of(menu.stream().collect(Collectors.toList()))
                .ifPresent(r -> {
                    System.out.println(r.getClass());
                    System.out.println(r);
                });
    }

    private static void testToSet(){
        System.out.println("testToSet");
        Optional.of(menu.stream().collect(Collectors.toSet()))
                .ifPresent(r->{
                    System.out.println(r.getClass());
                    System.out.println(r);
                });
    }
    private static void testToMap(){
        System.out.println("testToMap");
        Optional.of(menu.stream().collect(Collectors.toMap(Dish::getName,Dish::getCalories)))
                .ifPresent(v->{
                    System.out.println(v);
                    System.out.println(v.getClass());
                });
    }
    private static void testToMapWithBinaryOperator(){
        System.out.println("testToMapWithBinaryOperator");
        Optional.of(menu.stream().collect(Collectors.toMap(Dish::getType,v->1L,(a,b)->a+b)))
                .ifPresent(v->{
                    System.out.println(v);
                    System.out.println(v.getClass());
                });
    }
    private static void testToMapWithBinaryOperatorAndSupplier(){
        System.out.println("testToMapWithBinaryOperatorAndSupplier");
        Optional.of(menu.stream().collect(Collectors.toMap(Dish::getType,v->1L,(a,b)->a+b, Hashtable::new)))
                .ifPresent(v->{
                    System.out.println(v);
                    System.out.println(v.getClass());
                });
    }
}
