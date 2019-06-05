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
import java.util.Optional;
import java.util.stream.Collectors;

import static top.yhmi.CollectorsAction.menu;
public class CollectorsAction4 {
    public static void main(String[] args) {
        testSummingDouble();
    }
    private static void testSummingDouble(){
        System.out.println("testSummingDouble");
        Optional.of(menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories)))
                .ifPresent(System.out::println);
    }
}
