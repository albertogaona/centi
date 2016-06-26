package com.albertogaona.centi.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by alberto on 19/06/16.
 */
@SpringBootApplication
public class CentiApplication {
    public static void main (String [] args) {
        SpringApplication.run(CentiApplication.class, args);
    }
}
