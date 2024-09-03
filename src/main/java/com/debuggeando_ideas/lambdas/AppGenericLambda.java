package com.debuggeando_ideas.lambdas;

import com.debuggeando_ideas.fundamentals.Employee;
import com.debuggeando_ideas.fundamentals.Product;

public class AppGenericLambda {

    public static void main(String[] args) {

        Printer<String> printString = System.out::println;
        printString.print("Hello World");

        Printer<Product> printProduct = System.out::println;
        Product myProduct = new Product();
        myProduct.setId(23L);
        myProduct.setName("Laptop");
        myProduct.setPrice(1000.0);

        printProduct.print(myProduct);

        Printer<Employee> printEmploye = System.out::println;
        Employee myEmployee = new Employee();
        myEmployee.setDni("123");
        myEmployee.setName("Juan");
        myEmployee.setSalary(1000.0);

        printEmploye.print(myEmployee);
    }
}
