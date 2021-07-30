package org.sho.lambdas.parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

// https://dzone.com/articles/think-twice-using-java-8
public class Primes {

    private static final int MAX = 10;

    public static void main(String... args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        // Simulating multiple threads in the system
        // if one of them is executing a long-running task.
        // Some of the other threads/tasks are waiting
        // for it to finish
        es.execute(() -> countPrimes(MAX, 1000));
        // incorrect task
        es.execute(() -> countPrimes(MAX, 0));
        es.execute(() -> countPrimes(MAX, 0));
        es.execute(() -> countPrimes(MAX, 0));
        es.execute(() -> countPrimes(MAX, 0));
        es.execute(() -> countPrimes(MAX, 0));
        es.shutdown();
        es.awaitTermination(60, TimeUnit.SECONDS);
    }

    private static void countPrimes(int max, int delay) {
        System.out.println(
                IntStream.range(1, max).parallel().filter(Primes::isPrime).peek(i -> sleep(delay)).count());
    }

    private static void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (Exception e) {

        }
    }

    private static boolean isPrime(int n) {
        return n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);
    }
}
