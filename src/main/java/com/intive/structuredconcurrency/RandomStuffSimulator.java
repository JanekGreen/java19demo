package com.intive.structuredconcurrency;

import java.util.Random;

public class RandomStuffSimulator {
    public static void waitRandomTimeBetween(String where, int minSeconds, int maxSeconds ) throws InterruptedException {
        var time = getRandomNumberBetween(minSeconds, maxSeconds);
        long start = System.currentTimeMillis();
        long end;
        do {
            System.out.println("Working inside of: "+where);
            Thread.sleep(1000);
            end = System.currentTimeMillis();
       }while (((end - start)/1000) < time);
        System.out.println("Finished Working inside of: "+where);
    }
    public static int getRandomNumberBetween(int minSeconds, int maxSeconds ) throws InterruptedException {
        Random rnd = new Random(System.currentTimeMillis());
        return rnd.nextInt((maxSeconds-minSeconds)+1)+minSeconds;
    }
}
