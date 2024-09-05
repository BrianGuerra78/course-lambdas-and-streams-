package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Review;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        var myArray = videogames.distinct()
                .sorted(Comparator.comparing(Videogame::getTotalSold))
                .flatMap(videogame -> videogame.getReviews().stream()
                        .map(Review::getComment))
                .filter(coment -> coment.contains("best"))
                .map("Good comment: "::concat)
                .toArray();

        System.out.println(myArray);
    }
}
