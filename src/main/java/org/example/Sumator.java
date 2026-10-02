package org.example;

public class Sumator implements Runnable{
    private final int[] data;
    private final int start;
    private final int finish;
    private int sum = 0;

    public Sumator(int[] data, int start, int finish) {
        this.data = data;
        this.start = start;
        this.finish = finish;
    }
    @Override
    public void run() {
        for (int i = start; i < finish; i++) {
            sum += data[i];
        }
    }
    public int getSum() { return sum; }
}
