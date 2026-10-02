package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainPS {
    public static void main(String[] args) throws InterruptedException {
        int[] numbers = new int[40];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        Sumator sum1 = new Sumator(numbers, 0, 9);
        Sumator sum2 = new Sumator(numbers, 10, 19);
        Sumator sum3 = new Sumator(numbers, 20, 29);
        Sumator sum4 = new Sumator(numbers, 30, 39);

        ExecutorService eso = Executors.newFixedThreadPool(4);

        eso.submit(sum1);
        eso.submit(sum2);
        eso.submit(sum3);
        eso.submit(sum4);

        eso.shutdown();
        eso.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Suma total: " + (sum1.getSum() + sum2.getSum() + sum3.getSum() + sum4.getSum()));

        System.out.println("Sumatorio 1: " + sum1.getSum());
        System.out.println("Sumatorio 2: " + sum2.getSum());
        System.out.println("Sumatorio 3: " + sum3.getSum());
        System.out.println("Sumatorio 4: " + sum4.getSum());
    }
}