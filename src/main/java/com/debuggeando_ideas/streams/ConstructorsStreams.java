package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ConstructorsStreams {
    public static void main(String[] args) {

        Stream<Videogame> myStream = Database.videogames.stream();
        myStream.forEach(System.out::println);

        System.out.println("------------------------------------------------");

        Integer[] numbers = {1, 2, 3, 4, 5};
        Stream<Integer> intStream = Arrays.stream(numbers);
        intStream.forEach(System.out::println);

        System.out.println("------------------------------------------------");

        Stream.of("Hola","Mundo").forEach(System.out::println);

        System.out.println("------------------------------------------------");

        DoubleStream myDoubleStream = DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5);
        myDoubleStream.forEach(System.out::println);
    }
}
