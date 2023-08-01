package com.project1.demo1.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    //We need a bean here

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student ankita = new Student(
                    "Ankita",
                    LocalDate.of(2000, Month.APRIL,22),
                    "ankita2204.rani@gmail.com");
            Student rani = new Student(
                    "Rani",
                    LocalDate.of(1998, Month.MARCH,17),
                    "rani@gmail.com");
            repository.saveAll(List.of(ankita,rani));
        };
    }
}
