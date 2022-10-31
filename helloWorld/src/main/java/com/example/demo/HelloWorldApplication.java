package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/daikichi")
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
@RequestMapping("/travel/{where}")
public String travel(@PathVariable("where") String where1) {
	return "Congratulations! You will soon travel to "+where1+"!";
}
	
@RequestMapping("/lotto/{num}")
public String lotto(@PathVariable("num") int number) {
	if(number%2==0) {
		return "You will take a grand journey in the near future, but be weary of tempting offers'.";
	}
	return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
}
}

