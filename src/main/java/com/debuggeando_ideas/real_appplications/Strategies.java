package com.debuggeando_ideas.real_appplications;

public class Strategies {

    static ApplyDiscountStrategy basicDiscount = p -> p * 0.02;

    static ApplyDiscountStrategy plusDiscount = p -> p * 0.05;

    static ApplyDiscountStrategy primeDiscount = p -> p * 0.08;
}
