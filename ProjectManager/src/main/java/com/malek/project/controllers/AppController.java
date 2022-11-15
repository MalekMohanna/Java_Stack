package com.malek.project.controllers;

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

import com.malek.project.models.LoginUser;
import com.malek.project.models.Project;
import com.malek.project.models.User;
import com.malek.project.models.UserProject;
import com.malek.project.services.AppService;

@Controller
public class AppController {
    // -----------------------variables-----------------------
    @Autowired
    private AppService appService;
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if (userId == null) {
    		return "redirect:/";
    	} else {
    		User currentUser = appService.findUser(userId);
    		model.addAttribute("user", currentUser);
    		model.addAttribute("availableP",appService.availableProjects(currentUser));
    		model.addAttribute("userprojects",appService.userProjects(currentUser));
    		model.addAttribute("leader",appService.leadProjects(currentUser));
    		return "dashboard.jsp";
    	}
    }

    // create new
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
    		return "redirect:/dashboard";
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
    		return "redirect:/dashboard";
    	}
    	
    }
    
    // logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/dashboard";
    }
    
    @GetMapping("/projects/new")
    public String newproject(@ModelAttribute(name="project")Project project) {
    	return "newp.jsp";
    }
    @PostMapping("/createproject")
    public String createproject(@Valid @ModelAttribute(name="project")Project project,BindingResult result,HttpSession session) {
    	if(result.hasErrors()) {
    		return "newp.jsp";
    	}
    	else {
    		Long userId = (Long) session.getAttribute("user_id");
    		User currentUser = appService.findUser(userId);
    		appService.createProject(project, currentUser);
    		return "redirect:/dashboard";
    	}
    }
    
    @GetMapping("/jointeam/{userId}/{projectid}")
    public String joinTeam(@PathVariable("userId")Long userId,@PathVariable("projectid")Long proId) {
    appService.joinTeam(userId, proId);
		return "redirect:/dashboard";
    }
    
    @GetMapping("/leaveteam/{userId}/{projectid}")
    public String leaveteam(@PathVariable("userId")Long userId,@PathVariable("projectid")Long proId) {
    	appService.leaveTeam(userId, proId);
    	return "redirect:/dashboard";
    }
    
    @GetMapping("/projects/edit/{id}")
    public String editproject(@PathVariable("id")Long id,@ModelAttribute(name="project")Project project,Model model) {
    	Project proj=appService.findProjectById(id);
    	model.addAttribute("proj",proj);
    	return "editp.jsp";
    }
    @PutMapping("/projects/edit/{id}")
    public String updatee(@Valid @ModelAttribute(name="project")Project project,BindingResult result,@PathVariable("id")Long id) {
    	if(result.hasErrors()) {
    		return "editp.jsp";
    	}
    	else {
    		appService.updateProject(project, id);
    		return "redirect:/projects/"+id;
    	}
    }
    
    @GetMapping("/projects/{id}")
    public String showproject(@PathVariable("id")Long proId,Model model,HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		User currentUser = appService.findUser(userId);
		model.addAttribute("user",currentUser);
    	model.addAttribute("project",appService.findProjectById(proId));
    	
    	return "showp.jsp";
    }
    
    @DeleteMapping("/deletepro")
    public String deletepro(@RequestParam(name="proId")Long proId) {
    	appService.deleteProject(proId);
    	return "redirect:/dashboard";
    }
}