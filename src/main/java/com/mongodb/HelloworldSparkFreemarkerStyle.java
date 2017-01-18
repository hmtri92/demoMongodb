package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.*;
import spark.Response;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by thuynh40 on 1/18/2017.
 */
public class HelloworldSparkFreemarkerStyle {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloworldSparkFreemarkerStyle.class, "/");

        Spark.get("/", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("hello.ftl");

                    Map<String, Object> helloMap = new HashMap<String, Object>();
                    helloMap.put("name", "Minh Tri");

                    helloTemplate.process(helloMap, writer);
                    System.out.println(writer);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return writer;
            }
        });

    }
}
