package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<Integer> num1 = Arrays.asList(1, 2);
        List<Integer> num2 = Arrays.asList(3, 4);

        //flatmap
        List<int[]> num3 = num1.stream()
            .flatMap(i -> num2.stream().map(j -> new int[] {i, j})).collect(Collectors.toList());
        Supplier<Integer> supplier = new Random()::nextInt;

        Consumer<Integer> consumer = System.out::println;
        IntConsumer consumer1 = System.out::println;
        //reduce
        int[] numbers = new int[] {1, 2, 3, 4, 5, 6};
        int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
        OptionalInt sum2 = Arrays.stream(numbers).reduce(Integer::sum);
        sum2.ifPresent(consumer1);
        int plus = Arrays.stream(numbers).reduce(1, (a, b) -> a * b);

        int max = Arrays.stream(numbers).reduce(Integer.MIN_VALUE, (a, b)-> {
            if (a < b) {
                return b;
            } else {
                return a;
            }
        });
        consumer1.accept(max);
        Arrays.stream(numbers).max().ifPresent(consumer1);

        List<int[]> triples = IntStream.rangeClosed(1, 100)
            .boxed()
            .flatMap(a -> IntStream.rangeClosed(a, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)}))
            .collect(Collectors.toList());
        triples.forEach(a -> System.out.println(a[0] + " " + a[1] + " " + a[2]));

        Consumer<int[]> consumer2 = r -> System.out.println(r[0] + " " + r[1]);
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
            .limit(20).forEach(consumer2);



    }
}
