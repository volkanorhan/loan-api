package com.bank.loan.loanapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bank.loan")
@EnableJpaRepositories(basePackages = "com.bank.loan.repository")
@EntityScan(basePackages = "com.bank.loan.model")
public class LoanApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanApiApplication.class, args);
    }
}
