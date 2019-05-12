package top.yhmi;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMath {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        boolean mathed = stream.allMatch(i -> i > 0);
        System.out.println(mathed);
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        mathed = stream.anyMatch(i -> i > 6);
        System.out.println(mathed);
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        mathed = stream.noneMatch(i -> i <0);
        System.out.println(mathed);
    }
}
