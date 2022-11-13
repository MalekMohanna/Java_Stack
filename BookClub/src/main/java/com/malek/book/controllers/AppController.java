package com.malek.book.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.malek.book.models.Book;
import com.malek.book.models.LoginUser;
import com.malek.book.models.User;
import com.malek.book.services.AppService;

@Controller
public class AppController {
    // -----------------------variables-----------------------
    @Autowired
    private AppService appService;
    
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	} else {
    		User currentUser = appService.findUser(userId);
    		model.addAttribute("user", currentUser);
    		model.addAttribute("allbooks",appService.allBooks());
    		return "home.jsp";
    	}
    }
    
    //add book
    @GetMapping("/addbook")
    public String addbook(@ModelAttribute("book")Book book,BindingResult result) {
    	
    	return "newbook.jsp";
    }
    @PostMapping("/createbook")
    public String createbook(@Valid @ModelAttribute("book")Book book,BindingResult result,HttpSession session) {
    	if (result.hasErrors()) {
    		return "newbook.jsp";
    	}
    	else {
    	Long userId = (Long) session.getAttribute("user_id");
    	User currentUser = appService.findUser(userId);
    	book.setUser(currentUser);
    	appService.createBook(book);
    	
    	}
    	return "redirect:/home";
    }
    
    //open book
    @GetMapping("/book/{id}")
    public String showbook(@PathVariable("id")Long idBook,@ModelAttribute(name="book")Book book,Model model,HttpSession session) {
    	Book mybook=appService.findBookByID(idBook);
    	Long userId = (Long) session.getAttribute("user_id");
    	User currentUser = appService.findUser(userId);
    	model.addAttribute("book",mybook);
    	model.addAttribute("userId",userId);
    	return "showbook.jsp";
    }
    
    @PutMapping("/book/{id}")
    public String editbook(@Valid @ModelAttribute(name="book")Book book,@PathVariable("id")Long idbook,BindingResult result) {
    	if(result.hasErrors()) {
    		return "showbook.jsp";
    	}
    	else {
    		appService.updateBook(book, idbook);
    		return "redirect:/home";
    	}
    }
    
    //delete book
    @DeleteMapping("/deletebook")
    public String deleteBook(@RequestParam(name="bookID")Long id) {
    	appService.deleteBook((Long)id);
    	return "redirect:/home";
    }
    

    // create new user
    @GetMapping("/")
    public String index(Model model) {
    	model.addAttribute("newUser", new User());
    	model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
    	// do validation checks on email and password
    	appService.register(newUser, result);
    	
    	if (result.hasErrors()) {
    		model.addAttribute("newLogin", new LoginUser());
    		return "index.jsp";
    	} else {
    		session.setAttribute("user_id", newUser.getId());
    		return "redirect:/home";
    	}
    }
    
    // login
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
    	User user = appService.login(newLogin, result);
    	if (result.hasErrors()) {
    		model.addAttribute("newUser", new User());
    		return "index.jsp";
    	} else {
    		session.setAttribute("user_id", user.getId());
    		return "redirect:/home";
    	}
    	
    }
    
    // logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/home";
    }


}