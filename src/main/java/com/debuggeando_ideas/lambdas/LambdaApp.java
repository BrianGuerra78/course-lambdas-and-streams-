package com.debuggeando_ideas.lambdas;

public class LambdaApp {

    public static void main(String[] args) {
        //clase anonima
        Math subtract = new Math() {
            @Override
            public Double excecute(Double a, Double b) {
                return a - b;
            }
        };
        System.out.println(subtract.excecute(5.0, 3.0));

        //con exprecion lambda
        Math multiply = (a, b) -> a * b;

        System.out.println(multiply.excecute(5.0, 3.0));

        Math divide = (a, b) -> {
            System.out.println("Start");
            return a / b;
        };

        System.out.println(divide.excecute(500.0, 5.0));
    }
}
