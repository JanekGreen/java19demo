package com.intive.structuredconcurrency;

import jdk.incubator.concurrent.StructuredTaskScope;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class BetterServer {
    private final OrderService orderService = new OrderService();
    private final UserService userService = new UserService();

    Response handle() throws ExecutionException, InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<String>  user  = scope.fork(() -> userService.findUser());
            Future<Integer> order = scope.fork(() -> orderService.fetchOrder());

            scope.join();           // Join both forks
            scope.throwIfFailed();  // ... and propagate errors

            // Here, both forks have succeeded, so compose their results
            return new Response(user.resultNow(), order.resultNow());
        }
    }
}
