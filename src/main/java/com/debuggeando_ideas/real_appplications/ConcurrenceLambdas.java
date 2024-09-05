package com.debuggeando_ideas.real_appplications;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ConcurrenceLambdas {

    static Runnable printerSum = () -> {
        long sum = 0;
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
        System.out.println("Total: " + sum);
    };

    static Callable<Long> getSum = () -> {
        long sum = 0;
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
        return sum;
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName());
        var exec = Executors.newSingleThreadExecutor();
        exec.submit(printerSum);

        var result = exec.submit(getSum);
        System.out.println("Result: " + result.get());

        exec.shutdown();
    }
}
