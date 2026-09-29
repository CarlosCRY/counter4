package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class MainTR {
    public static void main (String[] args){
        Scanner scr = new Scanner (System.in);

        System.out.println("¿Cantidad de tortugas?");
        int cAmount = scr.nextInt();
        scr.nextLine();
        System.out.println("¿Cantidad de pasos?");
        int lAmount = scr.nextInt();
        scr.nextLine();

        List<Thread> threads = new LinkedList<>();
        long startTime = System.nanoTime();

        for (int i = 0; i < cAmount; i++) {
            Thread t = new Thread(new Counter("Contador - " + (i + 1), lAmount));
            threads.add(t);
            t.start();
        }

        for (Thread thread: threads){
            thread.join();
        }

        System.out.println("Fin de la operación");

        long endTime = System.nanoTime();

        System.out.println("Duración de la operación: " + (endTime - startTime) / 1000);
    }
    }
}
