package com.viktoriia_abakumova.lesson7.task7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter 'from' number: ");
            int fromNumber = scanner.nextInt();

            System.out.print("Enter 'to' number: ");
            int toNumber = scanner.nextInt();

            System.out.print("Enter 'number' of threads: ");
            int threadsNumber = scanner.nextInt();

            List<PrimeNumSearcher> primeNumSearchers = getPrimeNumSearchers(fromNumber, toNumber, threadsNumber);
            List<Integer> primeNumbers = collectPrimeNumbers(primeNumSearchers);

            System.out.println(primeNumbers);
        }
    }

    private static List<PrimeNumSearcher> getPrimeNumSearchers(int fromNumber, int toNumber, int threadsNumber) {
        List<PrimeNumSearcher> primeNumSearchers = new ArrayList<>();

        int perRange = toNumber / threadsNumber;
        int rangeFrom = fromNumber;
        int rangeTo = perRange;

        for (int i = 1; i <= threadsNumber; i++) {
            if (i > 1) {
                rangeFrom = rangeTo + 1;
                rangeTo += perRange;
            }
            if (i == threadsNumber) {
                rangeTo = toNumber;
            }

            PrimeNumSearcher primeNumSearcher = new PrimeNumSearcher(rangeFrom, rangeTo);
            primeNumSearchers.add(primeNumSearcher);
            primeNumSearcher.start();
        }
        return primeNumSearchers;
    }

    private static List<Integer> collectPrimeNumbers(List<PrimeNumSearcher> primeNumSearchers)
            throws InterruptedException {
        List<Integer> primeNumbers = new ArrayList<>();
        for (PrimeNumSearcher primeNumSearcher : primeNumSearchers) {
            primeNumSearcher.join();
            primeNumbers.addAll(primeNumSearcher.getPrimeNumbers());
        }
        return primeNumbers;
    }
}
