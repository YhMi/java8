package top.yhmi;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: CollectorIntroduce <br/>
 * Description: <br/>
 * date: 2019/5/18 18:08<br/>
 *
 * @author Administrator<br />
 * @Date: Created in 18:08 2019/5/18
 * @Modified By:
 */
public class CollectorIntroduce {
    public static void main(String[] args) {
        List<Apple> list= Arrays.asList(new Apple("green",150)
                ,new Apple("yellow",120)
                ,new Apple("green",170),
                new Apple("green",150)
                ,new Apple("yellow",120)
                ,new Apple("green",170));
        List<Apple> greenList = list.stream().filter(a -> a.getColor().equals("green")).collect(Collectors.toList());
        Optional.ofNullable(greenList).ifPresent(System.out::println);
        Optional.ofNullable(groupByNormal(list)).ifPresent(System.out::println );
        System.out.println("==================================================");
        Optional.ofNullable(groupByFunction(list)).ifPresent(System.out::println);
        System.out.println("==================================================");
        Optional.ofNullable(groupByCollector(list)).ifPresent(System.out::println);
    }
    private static Map<String,List<Apple>> groupByNormal(List<Apple> apples){
        Map<String,List<Apple>> map=new HashMap<>(1);
        for (Apple a:apples){
            List<Apple> list = map.get(a.getColor());
            if (null==list){
                list=new ArrayList<>();
                map.put(a.getColor(),list);
            }
            list.add(a);
        }
        return map;
    }
    private static Map<String,List<Apple>> groupByFunction(List<Apple> apples){
        Map<String,List<Apple>> map=new HashMap<>(1);
        apples.stream().forEach(a->{
            List<Apple> colorList = Optional.ofNullable(map.get(a.getColor())).orElseGet(() -> {
                List<Apple> list = new ArrayList<>();
                map.put(a.getColor(), list);
                return list;
            });
            colorList.add(a);
        });
        return map;
    }

    private static Map<String,List<Apple>> groupByCollector(List<Apple> apples){
        return apples.stream().collect(Collectors.groupingBy(Apple::getColor));
    }
}
