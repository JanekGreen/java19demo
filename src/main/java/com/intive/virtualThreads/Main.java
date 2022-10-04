package com.intive.virtualThreads;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //virtualThreadExample();
        platformThreadExample();
    }

    private static void virtualThreadExample() {
        long start = System.currentTimeMillis();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 100_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }  // executor.close() is called implicitly, and waits
        long end = System.currentTimeMillis();
        System.out.println("Duration: "+(end-start)/1000.0);
    }
    private static void platformThreadExample() {
        long start = System.currentTimeMillis();
        try (var executor = Executors.newFixedThreadPool(100_000)) {
            IntStream.range(0, 100_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }  // executor.close() is called implicitly, and waits
        long end = System.currentTimeMillis();
        System.out.println("Duration: "+(end-start)/1000.0);
    }
}
