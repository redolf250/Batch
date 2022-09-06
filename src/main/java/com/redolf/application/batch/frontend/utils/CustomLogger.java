package com.redolf.application.batch.frontend.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import static org.apache.commons.codec.language.bm.Rule.ALL;

@SuppressWarnings(ALL)
public class CustomLogger {

    public static LocalDateTime current = LocalDateTime.now();
    public static void logger(String message) throws IOException {
        FileWriter file = new FileWriter("/logs.txt",true);
        PrintWriter writer = new PrintWriter(file);
        writer.println(message);
        writer.flush();
        writer.close();
    }
}
