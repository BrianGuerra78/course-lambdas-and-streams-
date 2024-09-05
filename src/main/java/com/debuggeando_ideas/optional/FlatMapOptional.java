package com.debuggeando_ideas.optional;

import com.debuggeando_ideas.util.Movie;

import java.util.Optional;

public class FlatMapOptional {
    public static void main(String[] args) {

        Movie movie = new Movie("The Lord of the Rings", 10.0);

        Optional<Movie> movieOpt = Optional.of(movie);

        String movieName = movieOpt.flatMap(Movie::getName)
                .orElseThrow(RuntimeException::new);

        System.out.println(movieName);
    }
}
