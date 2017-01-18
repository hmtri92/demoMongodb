package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.*;
import spark.Response;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by thuynh40 on 1/18/2017.
 */
public class SparkFormHandling {
    public static void main(String[] args) {
        // configuration freemarker
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(SparkFormHandling.class, "/");

        Spark.get("/", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                try {
                    Map<String, Object> fruitsMap = new HashMap<String, Object>();
                    fruitsMap.put("fruits",
                            Arrays.asList("apple", "orange", "banana", "peach"));

                    Template template = configuration.getTemplate("fruitPicker.ftl");
                    StringWriter writer = new StringWriter();
                    template.process(fruitsMap, writer);

                    return writer;
                } catch (Exception e) {
                    return null;
                }
            }
        });

        Spark.post("/favorite_fruit", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                final String fruit = request.queryParams("fruit");

                if (fruit == null) {
                    return "Please choose!";
                } else {
                    return "Your favorite fruit is " + fruit;
                }
            }
        });
    }
}
