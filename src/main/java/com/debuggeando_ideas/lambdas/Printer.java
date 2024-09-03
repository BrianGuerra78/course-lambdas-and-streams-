package com.debuggeando_ideas.lambdas;

@FunctionalInterface
public interface Printer<T> {
    //metodo abstracto, solo puede existir uno por interface
    void print(T toPrint);
}
