package com.boa.embeddedInvestment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.boa.embeddedInvestment")
public class EmbeddedInvestmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmbeddedInvestmentApplication.class, args);
	}

}
