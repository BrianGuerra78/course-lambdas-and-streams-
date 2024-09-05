package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFinalOperators {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        Stream<Videogame> videogames2 = Database.videogames.stream();
        Stream<Videogame> videogames3 = Database.videogames.stream();
        Stream<Videogame> videogames4 = Database.videogames.stream();
        Stream<Videogame> videogames5 = Database.videogames.stream();
        Stream<Videogame> videogames6 = Database.videogames.stream();
        Stream<Videogame> videogames7 = Database.videogames.stream();
        Stream<Videogame> videogames8 = Database.videogames.stream();
        Stream<Videogame> videogames9 = Database.videogames.stream();
        Stream<Videogame> videogames10 = Database.videogames.stream();

        System.out.println("Count operator");
        countOperator(videogames);
        System.out.println("\nForEach operator");
        forEachOperator(videogames2);
        System.out.println("\nAnyMatch operator");
        anyMatchOperator(videogames3);
        System.out.println("\nAllMatch operator");
        allMatchOperator(videogames4);
        System.out.println("\nNoneMatch operator");
        noneMatchOperator(videogames5);
        System.out.println("\nFindFirst operator");
        findFirstOperator(videogames6);
        System.out.println("\nFindAny operator");
        findAnyOperator(videogames7);
        System.out.println("\nReduce operator");
        reduceOperator(videogames8);
        System.out.println("\nMax operator");
        maxOperator(videogames9);
        System.out.println("\nMin operator");
        minOperator(videogames10);
    }

    static void countOperator(Stream<Videogame> stream) {
        System.out.println("Total videogames: " + stream.count());
    }

    static void forEachOperator(Stream<Videogame> stream) {
        stream.forEach(System.out::println);
    }

    static void anyMatchOperator(Stream<Videogame> stream){
        boolean r = stream.anyMatch(v -> v.getTotalSold() > 1);
        System.out.println("Any match: " + r);
    }

    static void allMatchOperator(Stream<Videogame> stream){
        boolean r = stream.allMatch(v -> v.getTotalSold() > 1);
        System.out.println("All match: " + r);
    }

    static void noneMatchOperator(Stream<Videogame> stream){
        boolean r = stream.noneMatch(v -> v.getReviews().isEmpty());
        System.out.println("None match: " + r);
    }

    static void findFirstOperator(Stream<Videogame> stream){
        Optional<Videogame> r = stream.findFirst();
        System.out.println("First match: " + r);
    }

    static void findAnyOperator(Stream<Videogame> stream){
        Optional<Videogame> r = stream.findAny();
        System.out.println("Any match: " + r);
    }

    static void reduceOperator(Stream<Videogame> stream){
        Optional<Integer> r = stream.filter(Videogame::getIsDiscount)
                .map(Videogame::getTotalSold)
                .reduce(Integer::sum);
        System.out.println("Total sold with discount: " + r);
    }

    static void maxOperator(Stream<Videogame> stream){
        //Optional<Videogame> r = stream.max((v1, v2) -> v1.getName().compareTo(v2.getName()));
        Optional<Videogame> r = stream.max((Comparator.comparing(Videogame::getName)));
        System.out.println("Max total sold: " + r.get().getName());
    }

    static void minOperator(Stream<Videogame> stream){
        Optional<Videogame> r = stream.min((Comparator.comparing(Videogame::getName)));
        System.out.println("Min total sold: " + r.get().getName());
    }
}
