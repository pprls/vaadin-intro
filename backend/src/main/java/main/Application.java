package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"main.service.repository"})
@ComponentScan(basePackages = {"main.web" ,"main.model"})
public class Application {
    public static void main (String [] args) {
        SpringApplication.run(Application.class, args);
    }
}
