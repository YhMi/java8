package top.yhmi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamInAction {
    public static void main(String[] args) {
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader raoul = new Trader("Raoul", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1. Find All transactions in the year 2011 and sort them by value(small to height)
        List<Transaction> result = transactions.stream().filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(result);

        //2. What are all th unique cites where the traders work ?
        transactions.stream()
                .map(t->t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("============================");

        //3.Find all traders from Cambridge and sort them by name.
        transactions.stream().map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        //4. Return a string of all traders' names sorted alphabetically
        String value = transactions.stream().map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (name1, name2) -> name1 + name2);
        System.out.println(value);

        //5. Ary any traders based in Milan ?
        boolean liveInMilan1 = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        boolean liveInMilan2 = transactions.stream().map(Transaction::getTrader).anyMatch(trader -> trader.getCity().equals("Milan"));

        System.out.println(liveInMilan1);
        System.out.println(liveInMilan2);

        //6.Print all transactions' values from the traders living in Cambridge.
        transactions.stream()
                .filter(t->t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //7.What's the highest value of all the transactions ?
        Optional<Integer> maxValue = transactions.stream().map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(maxValue.get());

        //8. Find the transactions with the smallest value.
        Optional<Integer> minValue = transactions.stream().map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println(minValue.get());
    }
}
