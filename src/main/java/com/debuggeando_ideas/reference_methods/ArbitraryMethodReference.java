package com.debuggeando_ideas.reference_methods;

import java.util.function.BiPredicate;

public class ArbitraryMethodReference {
    public static void main(String[] args) {

        //BiPredicate<String,String> equals = (a, b) -> a.equals(b);
        BiPredicate<String,String> equals = String::equals;//referencia albitraria
        boolean isEquals = equals.test("Hello", "Hello");
        System.out.println(isEquals);
    }
}
