package com.debuggeando_ideas.real_appplications;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambdas {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4,3,6,8,7,5,8,10);
        numbers.sort((a, b) -> a - b);
        System.out.println(numbers);

        List<String> names = Arrays.asList("John", "Peter", "Mary", "Alice", "Bob");
        //names.sort((a, b) -> a.compareTo(b));
        names.sort(String::compareTo);
        System.out.println(names);

        names.sort(Comparator.reverseOrder());
        System.out.println(names);

        List<Person> persons = Arrays.asList(
                new Person("John", 30),
                new Person("Peter", 25),
                new Person("Alex", 25),
                new Person("Mary", 35)
        );

        persons.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        System.out.println(persons);
    }
}

