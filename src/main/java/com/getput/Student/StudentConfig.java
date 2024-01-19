package com.getput.Student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;
import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args->{
            Student logesh =new Student(
                "logesh",
                "logesh@gmail.com",
                LocalDate.of(2002, Month.AUGUST, 29)
        );
         Student alex =new Student(
                "alex",
                "alex@gmail.com",
                LocalDate.of(2005, Month.SEPTEMBER, 11)
        );
         Student akash =new Student(
                "akash",
                "akash@gmail.com",
                LocalDate.of(2007, Month.OCTOBER, 23)
        );
        repository.saveAll(
            List.of(logesh, alex,akash)
            );
        };
    }
    
}
