package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/Daikichi")
public class HelloWorldApplication {
	@RequestMapping("")
	public String hello() {
		return "Welcome!";
	}
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
		}
@RequestMapping("/today")
public String today() {
	return "Today you will find luck in all your endeavors!";
}
	
@RequestMapping("/tomorrow")
public String tomorrow() {
	return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
}

}

