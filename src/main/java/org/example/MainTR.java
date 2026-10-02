package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class MainTR {
    public static void main (String[] args)  throws InterruptedException {
        final String[] TNAMES = {"Leonardo", "Rafael", "Michelangelo", "Donatelo", "Tiziano", "Sandro"};
        Scanner scr = new Scanner (System.in);

        System.out.println("¿Cantidad de tortugas?");
        int tAmount = scr.nextInt();
        scr.nextLine();
        System.out.println("¿Cantidad de pasos?");
        int sAmount = scr.nextInt();
        scr.nextLine();

        List<Thread> threads = new LinkedList<>();
        long startTime = System.nanoTime();

        for (int i = 0; i < tAmount; i++) {
            Thread t;
            if (i < 6) {
                t = new Thread(new Turtle(TNAMES[i], sAmount));
            } else {
                t = new Thread(new Turtle("Tortuga " + (i + 1), sAmount));
            }
            threads.add(t);
            t.start();
        }

        for (Thread thread: threads){
            thread.join();
        }

        System.out.println("Carrera terminada");

        long endTime = System.nanoTime();

        System.out.println("Duración de la operación: " + (endTime - startTime) / 1000);
    }
}
