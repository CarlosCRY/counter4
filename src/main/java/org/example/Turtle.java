package org.example;

import java.util.Random;

public class Turtle implements Runnable {
    private final String name;
    private final int numPasos;

    public Turtle(String name, int numPasos) {
        this.name = name;
        this.numPasos = numPasos;
    }

    @Override
    public void run() {
        Random wait = new Random();
        for (int i = 0; i < numPasos; i++){
            System.out.println("Contador " + name + " - Vuelta: " + (i + 1));
            try {
                Thread.sleep(wait.nextInt(50,200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
