package com.tui.ordering.pilotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.tui.ordering.pilotes.out.jpa")
@EntityScan(basePackages = {"com.tui.ordering.pilotes.out.jpa"})
@SpringBootApplication(scanBasePackages = {"com.tui.ordering.pilotes"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}