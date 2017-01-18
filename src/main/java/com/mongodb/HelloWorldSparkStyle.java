package com.mongodb;

import spark.*;
import spark.Response;

/**
 * Created by thuynh40 on 1/18/2017.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        Spark.get("/", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                return "Hello world from spark.";
            }
        });
    }
}
