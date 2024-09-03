package com.debuggeando_ideas.lambdas;

@FunctionalInterface
public interface Math {

    Double excecute(Double a, Double b);//metodo abstracto, solo puede existir uno por interface

    default Double sum(Double a, Double b) { return  a + b; }
}
