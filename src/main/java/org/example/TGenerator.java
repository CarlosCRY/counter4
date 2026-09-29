package org.example;

import java.util.ArrayList;
import java.util.List;
public class TGenerator {
    private final static String[] NAMES = {"Leonardo", "Rafael", "Michelangelo", "Donatelo", "Tiziano", "Sandro"};

    public List<Turtle> generate (int x, int y) {
        List<Turtle> z = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            if (i < 6) {
                z.add(new Turtle(NAMES[i], y));
            } else {
                z.add(new Turtle("Tortuga " + (i + 1), y));
            }
        }
        return z;
    }
}
