package com.nevermind.bu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class PhoneBookApplication {

    public static void main(String[] args) {
//        SpringApplication.run(PhoneBookApplication.class, args);

        SpringApplication application = new SpringApplication(PhoneBookApplication.class);
        application.setAddCommandLineProperties(true);

        String propertiesPath = "E:\\Dev\\New\\phonebook\\application.properties";
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(propertiesPath)));
            application.setDefaultProperties(properties);
            application.run(args);
        } catch (IOException e) {
            System.out.println("Can't find file by this path");
            e.printStackTrace();
        }
    }
}
