package com.investmentPortfolio.creatingPortfolio.company;

import java.time.LocalDate;
import java.util.List;

import com.investmentPortfolio.creatingPortfolio.CompanyDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfig {
    @Bean
    CommandLineRunner commandLineRunner(CompanyRepository repository){
        return args -> {
            Company Man= new Company(123l, "m", "man", 5.1, 6.0, 12.0, 31.1,1l,200000, 16.1, 320000.0, 40.0, 8.0, 12000.0, 25.0, 6000.0, 12.0, 42.0, 15.0, 12.0);
            Company Amazon= new Company(1321l,"AMZ", "amazon", 50.44, -0.27, 14.33, 6.25,2l,10189, -470.5, 513983.0, 2.4, 41921.0, -2722.0, 54.2, 140118.0, 146043.0, -0.5, 1.9, -0.5);
            repository.saveAll(List.of(Man,Amazon));
        };
    }
}
