package com.viktoriia_abakumova.task7;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumSearcher extends Thread {

    private List<Integer> primeNumbers = new ArrayList<>();

    private int from;
    private int to;

    public PrimeNumSearcher(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public List<Integer> getPrimeNumbers() {
        return primeNumbers;
    }

    @Override
    public void run() {
        for (int i = from; i <= to; i++) {
            if (isPrimeNumber(i)) {
                primeNumbers.add(i);
                break;
            }
        }
    }

    private boolean isPrimeNumber(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
