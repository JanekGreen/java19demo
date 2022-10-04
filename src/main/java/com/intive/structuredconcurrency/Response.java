package com.intive.structuredconcurrency;

public class Response {
    String user;
    Integer order;

    public Response(String user, Integer order) {
        this.user = user;
        this.order = order;
    }

    @Override
    public String toString() {
        return "Response{" +
                "user='" + user + '\'' +
                ", order=" + order +
                '}';
    }
}
