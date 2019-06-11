package top.yhmi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class CustomerCollectorAction {
    public static void main(String[] args) {
        Collector<String, List<String>,List<String>> collector=new TolistCollector();
        String [] arrs=new String[]{"Alex","Wang","Hello","Lambda","Collector","Java 8","Stream"};
        List<String> result = Arrays.stream(arrs)
                .filter(s -> s.length() > 5)
                .collect(collector);
        System.out.println(result);

    }
}
