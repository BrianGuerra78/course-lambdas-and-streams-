package com.debuggeando_ideas.optional;

import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {

        Optional<Videogame> gtaOpt = Optional.ofNullable(Database.videogames.get(5));
        Optional<Videogame> gtaOpt2 = Optional.ofNullable(null);

        System.out.println("1- " + gtaOpt.get());

        System.out.println("2- " + gtaOpt2.orElse(Database.videogames.get(6)));

        System.out.println("3- " + gtaOpt2.orElseThrow(() -> new RuntimeException("No existe el videojuego")));
    }
}
