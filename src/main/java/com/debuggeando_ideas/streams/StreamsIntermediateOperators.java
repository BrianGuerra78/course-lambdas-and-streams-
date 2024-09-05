package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.BasicVideogame;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Review;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsIntermediateOperators {
    public static void main(String[] args) {

        Stream<Videogame> videogameStream = Database.videogames.stream();
        Stream<Videogame> videogameStream2 = Database.videogames.stream();
        Stream<Videogame> videogameStream3 = Database.videogames.stream();
        Stream<Videogame> videogameStream4 = Database.videogames.stream();
        Stream<Videogame> videogameStream5 = Database.videogames.stream();
        Stream<Videogame> videogameStream6 = Database.videogames.stream();
        Stream<Videogame> videogameStream7 = Database.videogames.stream();
        Stream<Videogame> videogameStream8 = Database.videogames.stream();
        Stream<Videogame> videogameStream9 = Database.videogames.stream();
        Stream<Videogame> videogameStream10 = Database.videogames.stream();
        Stream<Videogame> videogameStream11 = Database.videogames.stream();
        Stream<Videogame> videogameStream12 = Database.videogames.stream();

        System.out.println("Distinct Operator");
        distinctOperator(videogameStream);
        System.out.println("Limit Operator");
        limitOperator(videogameStream2);
        System.out.println("Skip Operator");
        skipOperator(videogameStream3);
        System.out.println("Filter Operator");
        filterOperator(videogameStream4);
        System.out.println("Map Operator");
        mapOperator(videogameStream5);
        System.out.println("mapMap Operator");
        mapMapOperator(videogameStream6);
        System.out.println("FlatMap Operator");
        flatMapOperator(videogameStream7);
        System.out.println("Map vs FlatMap Operator");
        mapVSflatMapOperator(videogameStream8);
        System.out.println("Peek Operator");
        peekOperator(videogameStream9);
        System.out.println("Sort Operator");
        sortOperator(videogameStream10);
        System.out.println("TakeWhile Operator");
        takeWhileOperator(videogameStream11);
        System.out.println("DropWhile Operator");
        dropWhileOperator(videogameStream12);
    }

    static void distinctOperator(Stream<Videogame> stream) {
        System.out.println(stream.distinct().count());
    }

    static void limitOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream.limit(5).collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void skipOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream.skip(15).collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void filterOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream.filter(v -> v.getPrice() > 5.0)
                .filter(v -> !v.getIsDiscount())
                .filter(v -> v.getOfficialWebsite().contains("forza"))
                .collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void mapOperator(Stream<Videogame> stream) {
        List<BasicVideogame> basicVideogames = stream.map(v -> {
            return BasicVideogame.builder()
                    .name(v.getName())
                    .price(v.getPrice())
                    .console(v.getConsole())
                    .build();
                }).collect(Collectors.toList());
        basicVideogames.forEach(System.out::println);

        System.out.println("--------------------");

        //Stream<BasicVideogame> stream2 = basicVideogames.stream();
        //List<String> titles = stream2.map(BasicVideogame::getName).collect(Collectors.toList());
        List<String> titles = basicVideogames.stream().map(BasicVideogame::getName).collect(Collectors.toList());
        titles.forEach(System.out::println);
    }

    static void mapMapOperator(Stream<Videogame> stream) {//lo maneja como lista de listas
        var r = stream.map(v -> v.getReviews()).collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void flatMapOperator(Stream<Videogame> stream) {
        //var r = stream.flatMap(v -> v.getReviews().stream()).collect(Collectors.toList());
        List<Review> r = stream.flatMap(v -> v.getReviews().stream()).collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void mapVSflatMapOperator(Stream<Videogame> stream) {
        //var totalReviews = stream.map(v -> v.getReviews().size()).collect(Collectors.toList());
        //System.out.println(totalReviews.size());
        //no suma los revies totales, solo los de cada juego

        //Long totalReviews = stream.flatMap(v -> v.getReviews().stream()).count();
        Long totalReviews = stream.mapToLong(v -> v.getReviews().size()).sum();

        System.out.println(totalReviews);
    }

    static void peekOperator(Stream<Videogame> stream) {
        //stream.peek(System.out::println).collect(Collectors.toList());
        stream.peek(v -> v.setName("")).forEach(System.out::println);
    }

    static void sortOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream.sorted(Comparator.comparingInt(v -> v.getReviews().size()))
                .collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void takeWhileOperator(Stream<Videogame> stream) {//regresa antes del primer elemento que cumple la condicion
        List<Videogame> r = stream.sorted(Comparator.comparing(Videogame::getName))
                .takeWhile(v -> v.getName().startsWith("M"))
                .collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void dropWhileOperator(Stream<Videogame> stream) {//regresa los ultimos
        List<Videogame> r = stream.sorted(Comparator.comparing(Videogame::getName))
                .dropWhile(v -> v.getName().startsWith("M"))
                .collect(Collectors.toList());
        r.forEach(System.out::println);
    }
}
