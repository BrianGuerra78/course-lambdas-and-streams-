package com.debuggeando_ideas.fundamentals;

import java.util.List;

public class App {

    public static void main(String[] args) {

        DatabaseService mongo = new MongoDB();
        DatabaseService postgres = new PostgresDB();

        System.out.println(mongo.getById(20L));
        System.out.println(postgres.getById(30L));

        ProductDB productDB = new ProductDB();
        EmployeeDB employeeDB = new EmployeeDB();

        System.out.println(productDB.getById(1L));
        System.out.println(employeeDB.getById(2L));

        //Clase anonima solo se utiliza una vez
        System.out.println(Product.class.getName());
        System.out.println(Employee.class.getName());
        System.out.println(String.class.getName());

        DatabaseService<String> dbAnonimo = new DatabaseService<String>() {
            @Override
            public String getById(Long id) {
                return "Hola mundo";
            }

            @Override
            public List<String> getAllRecords() {
                return null;
            }
        };

        System.out.println(dbAnonimo.getClass().getName());
    }

}
