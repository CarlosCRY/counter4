package org.example;

import java.util.Random;

public class Counter implements Runnable {
    private final String name;
    private final int numVueltas;

    public Counter (String name) {
        this.name = name;
    }

    public Counter (int numVueltas) {
        this.numVueltas = numVueltas;
    }

    @Override
    public void run() {
        Random wait = new Random();

        Thread.sleep(wait.nextInt(100,500));

    }
}
