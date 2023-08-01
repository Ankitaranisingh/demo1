package com.project1.demo1;

import com.project1.demo1.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
//@RestController //makes the below class to serve restful API
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
		System.out.println("server loaded");

	}
	//@GetMapping("/hello") //to serve the below method as restful api get cuz we want some output for ourselves
//	public int printhello(){
//
//		return 2+3;
//	}


}
