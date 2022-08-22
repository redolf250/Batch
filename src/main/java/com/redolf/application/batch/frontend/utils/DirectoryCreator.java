package com.redolf.application.batch.frontend.utils;

import java.io.File;
import java.io.IOException;

import static com.redolf.application.batch.frontend.controller.Batch.CSV_FILE;
import static com.redolf.application.batch.frontend.controller.Batch.XML_FILE;

public class DirectoryCreator {

    public static String makeDir(){
        File directory = new File( "C:\\Batch\\data");
            if (!directory.exists()){
                directory.mkdirs();
            }
        return directory.getAbsolutePath();
    }

    public static String createFile(String name) throws IOException {
        File file = new File(makeDir()+"\\"+name);
        if(!file.exists()){
            if (name.endsWith(CSV_FILE) || name.endsWith(XML_FILE)){
                file.createNewFile();
            }
        }
        return file.getAbsolutePath();
    }
}
