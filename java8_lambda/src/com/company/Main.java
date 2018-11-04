package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //comparator
        Comparator<Integer> comparator = (a, b) -> a - b;

        List<String> names = Arrays.asList("Tony", "Jon", "Arya", "Sansa");

        //loop
        names.forEach(name -> System.out.print(name));
        //loop2
        names.forEach(System.out::print);


        //filter
        Predicate<String> isLongName = name -> name.length() >= 3;
        List<String> subNames = new ArrayList<>();
        for (String name : names) {
            if (isLongName.test(name)) {
                subNames.add(name);
            }
        }

        List<String> subNames2 = names.stream().filter(name -> name.length() >= 3).collect(Collectors.toList());

        subNames.forEach(System.out::println);
        System.out.println(subNames);

        //map
        Function<String, Integer> getNameLength = name -> name.length();
        Function<String, Integer> getNameLength2 = String::length;
        List<Integer> nameLengths = new ArrayList<>();
        for (String name : names) {
            nameLengths.add(getNameLength.apply(name));
        }

        //map2
        List<Integer> mapLength2 = names.stream().map(name -> name.length()).collect(Collectors.toList());

        nameLengths.forEach(System.out::println);

        List<People> peoples = Arrays.asList(new People("Rob", 15, "male"),
                new People("Job", 13, "male"),
                new People("Sansa", 11, "female"),
                new People("Aray", 9, "female"),
                new People("Bran", 7, "male"),
                new People("Rikkon", 3, "male"));

        List<String> genderList = peoples.stream().map(People::getGender).distinct().collect(Collectors.toList());

        //limit
        List<People> getFirst2People = peoples.stream().limit(2).collect(Collectors.toList());

        //consumer
        Consumer<People> peopleConsumer = people -> System.out.println(people.getName());
        for (People people : peoples) {
            peopleConsumer.accept(people);
        }

        //group filters
        Predicate<People> male = people -> "male".equals(people.getGender());
        Predicate<People> oldThan10 = people -> people.getAge() >= 10;

        List<People> filterPeople = new ArrayList<>();
        for (People people : peoples) {
            if (male.and(oldThan10).test(people)) {
                filterPeople.add(people);
            }
        }

        //
        Comparator<People> comparator1 = (a, b) -> a.getAge() - b.getAge();

        peoples.sort(comparator1);
        peoples.sort(Comparator.comparing(People::getName));

        //test
        String[] words = new String[]{"hello", "world"};
        List<String> distinctWords =
                Arrays.stream(words).map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());

        //test1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> squares = numbers.stream().map(n -> n * n).collect(Collectors.toList());

        //test2
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(4, 5);
        List<int[]> result =
                numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[] {i, j})).collect(Collectors.toList());

    }
}