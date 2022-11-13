package com.ctwyrth.languages.controllers;

import java.util.List;

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

import com.ctwyrth.languages.models.Language;
import com.ctwyrth.languages.services.LanguageService;

@Controller
public class LanguageController {
    // -----------------------variables-----------------------
    @Autowired
    private LanguageService languageService;
	
    // show all and create new
    // These may be split apart into a create/get, a create/post, and a showall
    @GetMapping("/languages")
    public String index(@ModelAttribute("language") Language language, Model model) {
    	List<Language> languages = languageService.allLanguages();
    	model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }
    @PostMapping("/languages")
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		List<Language> languages = languageService.allLanguages();
        	model.addAttribute("languages", languages);
    		return "/languages/index.jsp";
    	} else {
    		languageService.createLanguage(language);
    		return "redirect:/languages";
    	}
    }

    // display one found by id
    @GetMapping("/languages/{id}")
    public String showOneLanguageById(@PathVariable("id") Long id, Model model) {
        Language languageToShow = languageService.findLanguage(id);
        model.addAttribute("language", languageToShow);
        return "/languages/show.jsp";
    }
	
    // update one found by id
    @GetMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Language languageToShow = languageService.findLanguage(id);
    	model.addAttribute("language", languageToShow);
    	return "/languages/edit.jsp";
    }
    @PutMapping("/languages/{id}")
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	if (result.hasErrors()) {
        	return "/languages/edit.jsp";
	} else {
		languageService.updateLanguage(language);
		return "redirect:/languages";
	}
    }
	
    // delete one
    @DeleteMapping("/languages/{id}")
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}