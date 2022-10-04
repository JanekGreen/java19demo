package com.intive.structuredconcurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server {
    private final OrderService orderService = new OrderService();
    private final UserService userService = new UserService();
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);
    public Response handle() throws ExecutionException, InterruptedException {

        Future<String> user  = executorService.submit(() -> userService.findUser());
        Future<Integer> order = executorService.submit(() -> orderService.fetchOrder());
        String theUser  = user.get();   // Join findUser
        int   theOrder = order.get();  // Join fetchOrder
        return new Response(theUser, theOrder);
    }
}
