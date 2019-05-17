package top.yhmi;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStream {
    public static void main(String[] args) {
        Stream<Integer> stream= Arrays.stream(new Integer[]{1,2,3,4,5,6,7});
        IntStream intStream = stream.mapToInt(i -> i.intValue());
        int result=intStream.filter(i->i>3).sum();
        System.out.println(result);

        int a = 9;
        // 1...1000
        IntStream.rangeClosed(1, 100000)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(x->new int[]{a,x,(int) Math.sqrt(a*a+x*x)})
                .forEach(r-> System.out.println("a="+r[0]+",b="+r[1]+",c="+r[2]));
        System.out.println("====================================");
        IntStream.rangeClosed(1, 100000)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(x->new int[]{a,x,(int)Math.sqrt(a*a+x*x)})
                .forEach(r-> System.out.println("a="+r[0]+",b="+r[1]+",c="+r[2]));
    }
}
