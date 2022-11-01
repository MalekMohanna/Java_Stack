package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class CounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}
	@RequestMapping("/")
	public String index(HttpSession session,Model model) {
		if (session.getAttribute("count") == null) {
		session.setAttribute("count", 0);
		}
		else {
		Integer counter = (Integer) session.getAttribute("count");
		int increase = counter+1;
		session.setAttribute("count", increase);
		}

		model.addAttribute("myCount",session.getAttribute("count"));
		return "index.jsp";
	}
}
