package com.intive.structuredconcurrency;


import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Server server = new Server();
        BetterServer server = new BetterServer();
        Response handle = server.handle();
        System.out.println(handle);

    }

}