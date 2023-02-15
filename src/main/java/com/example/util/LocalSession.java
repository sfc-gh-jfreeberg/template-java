package com.example.util;

import com.snowflake.snowpark_java.Session;

public class LocalSession {
    public static Session getLocalSession() {
        try {
            String password = System.getenv("SNOWFLAKE_PASSWORD");

            return Session.builder()
                .configFile("src/main/resources/dev.properties")
                .config("password", password)
                .create();
        } catch (NullPointerException e) {
            System.out.println("ERROR: Environment variable, SNOWFLAKE_PASSWORD, not found. Please set this variable");
            e.printStackTrace();
            return null;
        }
    }
}
