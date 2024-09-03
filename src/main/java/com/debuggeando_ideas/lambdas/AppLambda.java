package com.debuggeando_ideas.lambdas;

import java.util.List;

public class AppLambda {

    public static void main(String[] args) {
        List<String> countries = List.of("Argentina", "Brasil", "Chile", "Colombia", "Ecuador", "Perú", "Uruguay", "Venezuela");

        for (String c : countries) {
            System.out.println(c);
        }

        //exprecion lambda
        countries.forEach(c -> System.out.println(c.toUpperCase()));
    }
}
