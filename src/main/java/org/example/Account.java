package org.example;

public class Account {
    private int saldo = 0;

    public void ingresar(int cantidad) {
        saldo = saldo + cantidad;
    }

    public int getSaldo() {
        return saldo;
    }
}
