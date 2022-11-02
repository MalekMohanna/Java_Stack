package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllerone {
@RequestMapping("/")
public String change() {
	return "redirect:/omikuji";
}
@RequestMapping("/omikuji")
public String index() {
	return "index.jsp";
}
@PostMapping("/process")
public String process(
		@RequestParam(value="num") Integer number,
		@RequestParam(value="city") String city,
		@RequestParam(value="person") String person,
		@RequestParam(value="hobby") String hobby,
		@RequestParam(value="living") String living,
		@RequestParam(value="mytext") String mytext,
		HttpSession session,Model model) {
	
	model.addAttribute("number",number);
	model.addAttribute("city",city);
	model.addAttribute("person",person);
	model.addAttribute("hobby",hobby);
	model.addAttribute("living",living);
	model.addAttribute("mytext",mytext);
	session.setAttribute("data", model);
	
	return "redirect:/omikuji/show";
	
}

@RequestMapping("/omikuji/show")
public String show() {
	return "result.jsp";
			
}
}
