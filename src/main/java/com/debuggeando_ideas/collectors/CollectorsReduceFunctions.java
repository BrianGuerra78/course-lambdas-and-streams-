package com.debuggeando_ideas.collectors;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsReduceFunctions {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        Stream<Videogame> videogames2 = Database.videogames.stream();
        Stream<Videogame> videogames3 = Database.videogames.stream();

        avg(videogames);
        sum(videogames2);
        join(videogames3);
    }

    static void avg(Stream<Videogame> stream){
        Double avg= stream.collect(Collectors.averagingDouble(Videogame::getPrice));
        System.out.println("Average price: " + avg);
    }

    static void sum(Stream<Videogame> stream){
        IntSummaryStatistics summaryStatistics = stream.collect(Collectors.summarizingInt(v -> v.getReviews().size()));
        System.out.println("Total reviews: " + summaryStatistics.getSum());
        System.out.println("Average average: " + summaryStatistics.getAverage());
        System.out.println("Max average: " + summaryStatistics.getMax());
        System.out.println("Min average: " + summaryStatistics.getMin());
    }

    static void join(Stream<Videogame> stream){
        String joined = stream.map(Videogame::toString)
                .collect(Collectors.joining("\n"));
        System.out.println("Joined: " + joined);
    }
}
