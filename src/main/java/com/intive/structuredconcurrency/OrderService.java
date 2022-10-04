package com.intive.structuredconcurrency;

public class OrderService {
    public Integer fetchOrder() throws InterruptedException {
        System.out.println("Order service starts working....");
        RandomStuffSimulator.waitRandomTimeBetween("fetchOrder", 10, 20);
        return RandomStuffSimulator.getRandomNumberBetween(1000, 2000);
    }
}
