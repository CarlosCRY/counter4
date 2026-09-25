package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import java.util.Scanner;

public class MainE {
    public static void main(String[] args) throws InterruptedException {
        Scanner scr = new Scanner (System.in);

        System.out.println("¿Cantidad de contadores?");
        int cAmount = scr.nextInt();
        scr.nextLine();
        System.out.println("¿Cantidad de vueltas?");
        int lAmount = scr.nextInt();
        scr.nextLine();

        ExecutorService eso = Executors.newFixedThreadPool(cAmount);

        long startTime = System.nanoTime();

        for (int i = 0; i < cAmount; i++) {
            eso.submit(new Counter("Contador - " + (i + 1), lAmount));
        }

        eso.shutdown();

        eso.awaitTermination(10, TimeUnit.MINUTES);

        System.out.println("Fin de la operación");

        long endTime = System.nanoTime();

        System.out.println("Duración de la operación: " + (endTime - startTime) / 1000);
    }
}