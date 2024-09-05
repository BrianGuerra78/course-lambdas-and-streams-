package com.debuggeando_ideas.real_appplications;

import java.util.List;

public class StrategyLambdas {

    public static void main(String[] args) {

        var product1 = Product.builder()
                .id(1L)
                .userType("BASIC")
                .name("Bear")
                .price(150.0)
                .build();

        var product2 = Product.builder()
                .id(1L)
                .userType("PLUS")
                .name("Bear")
                .price(150.0)
                .build();
        var product3 = Product.builder()
                .id(1L)
                .userType("PRIME")
                .name("Bear")
                .price(150.0)
                .build();

        var products = List.of(product1, product2, product3);
        products.forEach(product -> {
            switch (product.getUserType()){
                case "BASIC" :product.setApplyDiscountStrategy(Strategies.basicDiscount);
                break;
                case "PLUS" :product.setApplyDiscountStrategy(Strategies.plusDiscount);
                    break;
                case "PRIME" :product.setApplyDiscountStrategy(Strategies.primeDiscount);
                    break;
            }
        });

        products.forEach(product -> {
            System.out.println("UserType " + product.getUserType() + " Name " + product.getName() + " price: " + product.getPrice() + " discount: " + product.getApplyDiscountStrategy().get(product.getPrice()));
        });
    }
}
