package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.isNew()) {
			ArrayList<String> mylog = new ArrayList<String>();
			session.setAttribute("total_gold", 0);
			session.setAttribute("log", mylog);

		}
		return "index.jsp";
	}

	@PostMapping("/process_money")
	public String money(@RequestParam(value = "where") String where, HttpSession session) {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-DD-yyyy HH:mm a");
		String formattedDate = myDateObj.format(myFormatObj);
		Random rl = new Random();
		int luck = rl.nextInt(3 - 1) + 1;
		System.out.println(luck);
		if (luck == 1) {
			if (where.equals("farm")||where.equals("house")||where.equals("cave")) {
				System.out.println(where);
				Random r = new Random();
				int result = r.nextInt(20 - 10) + 10;
				String time = formattedDate;
				session.setAttribute("total_gold", (int) session.getAttribute("total_gold") + result);
				ArrayList<String> temp = (ArrayList<String>) session.getAttribute("log");
				temp.add(0, "<p class=text-success>You have entered a " + where + " and earned " + result + " gold. "
						+ (String) time + "</p>");
				session.setAttribute("log", temp);
			}
			if (where.equals("quest")) {
				System.out.println(where);
				Random r = new Random();
				int result = r.nextInt(50 - 0) + 0;
				String time = formattedDate;
				session.setAttribute("total_gold", (int) session.getAttribute("total_gold") + result);
				ArrayList<String> temp = (ArrayList<String>) session.getAttribute("log");
				temp.add(0, "<p class=text-success>You have entered a " + where + " and earned " + result + " gold. "
						+ (String) time + "</p>");
				session.setAttribute("log", temp);
			}
			
		}
		else if (luck == 2) {
			if (where.equals("farm")||where.equals("house")||where.equals("cave")) {
				Random r = new Random();
				int result = r.nextInt(20 - 10) + 10;
				String time = formattedDate;
				session.setAttribute("total_gold", (int) session.getAttribute("total_gold") - result);
				ArrayList<String> temp = (ArrayList<String>) session.getAttribute("log");
				temp.add(0, "<p class=text-danger>You have lost a quest and lost -" + result + " gold. "
						+ (String) time + "</p>");
				session.setAttribute("log", temp);
			}
			if (where.equals("quest")) {
				Random r = new Random();
				int result = r.nextInt(50 - 0) + 0;
				String time = formattedDate;
				session.setAttribute("total_gold", (int) session.getAttribute("total_gold") - result);
				ArrayList<String> temp = (ArrayList<String>) session.getAttribute("log");
				temp.add(0, "<p class=text-danger>You have lost a quest and lost -" + result + " gold. "
						+ (String) time + "</p>");
				session.setAttribute("log", temp);
			}
			
		}
		return "redirect:/";

	}
	
	@PostMapping("/clear")
	public String delete(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}