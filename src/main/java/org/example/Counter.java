package org.example;

import java.util.Random;

public class Counter implements Runnable {
    private final String name;
    private final int numVueltas;

    public Counter (String name, int numVueltas) {
        this.name = name;
        this.numVueltas = numVueltas;
    }

    @Override
    public void run() {
        Random wait = new Random();
        for (int i = 0; i < numVueltas; i++){
            System.out.println("Contador " + name + " - Vuelta: " + (i + 1));
            try {
                Thread.sleep(wait.nextInt(100,500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
