package com.tg.spel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tg.spel")
public class SpelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpelApplication.class, args);
    }
}
