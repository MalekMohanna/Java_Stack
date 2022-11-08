package com.malek.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.malek.dojos.models.Dojo;
import com.malek.dojos.models.Ninja;
import com.malek.dojos.services.DojoService;
import com.malek.dojos.services.NinjaService;

@Controller
public class DojoController {
	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;
	@GetMapping("/")
	public String redi() {
		return "redirect:/dojo/new";
	}
@GetMapping("/dojo/new")
public String index( @ModelAttribute("dojo") Dojo dojo) {
	return "index.jsp";
}
@PostMapping("/newdojo")
public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo,
		BindingResult result) {
	if(result.hasErrors()) {
		return "index.jsp";
	}
	else {
		dojoService.createDojo(dojo);
		return "redirect:/show";
	}
}
@GetMapping("/ninja/new")
public String ninja(@ModelAttribute("ninja") Ninja ninja,Model model) {
	model.addAttribute("dojos",dojoService.allDojos());
	return "ninja.jsp";
}
@PostMapping("/newninja")
public String newNninja(@Valid @ModelAttribute("ninja") Ninja ninja,
		BindingResult result) {
	if(result.hasErrors()) {
		return "ninja.jsp";
	}
	else {
		ninjaService.createNinja(ninja);
		return "redirect:/show";
	}
}
@GetMapping("/show")
public String show(Model model) {
	model.addAttribute("ninjasShow",ninjaService.allNinjas());
	model.addAttribute("dojosShow",dojoService.allDojos());
	return "show.jsp";
}

@GetMapping("/dojo/{id}")
public String dojoos(@PathVariable("id") Long id,Model model) {
	Dojo mydojo = dojoService.findDojo(id);
	model.addAttribute("mydojo",mydojo);
	return "ninjas.jsp";
}

}
