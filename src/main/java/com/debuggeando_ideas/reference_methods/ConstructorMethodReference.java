package com.debuggeando_ideas.reference_methods;

import java.util.function.Supplier;

public class ConstructorMethodReference {
    public static void main(String[] args) {

        //Supplier<MyObject> newMyObject = () -> new MyObject();
        Supplier<MyObject> newMyObject = MyObject::new;
        System.out.println(newMyObject.get());
    }
}


