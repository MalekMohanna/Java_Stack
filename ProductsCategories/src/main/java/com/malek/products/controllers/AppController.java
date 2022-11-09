package com.malek.products.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.malek.products.models.Category;
import com.malek.products.models.CategoryProduct;
import com.malek.products.models.Product;
import com.malek.products.services.AppService;

@Controller
public class AppController {
	@Autowired
	AppService appService;
@GetMapping("/")
public String index(Model model) {
	model.addAttribute("products",appService.allProducts());
	model.addAttribute("categories",appService.allCategorys());
	return "index.jsp";
}

@GetMapping("/product/new")
public String product(@ModelAttribute(name="product")Product product) {
	return "product.jsp";
}
@PostMapping("/products")
public String newproduct(@Valid @ModelAttribute(name="product") Product product,BindingResult result) {
	if(result.hasErrors()) {
		return "product.jsp";
	}
	else {
	appService.createProduct(product);
	return "redirect:/";
	}
	
}
@GetMapping("/category/new")
public String category(@ModelAttribute(name="category")Category categorie) {
	return "category.jsp";
}
@PostMapping("/categories")
public String newcat(@Valid @ModelAttribute("category")Category category,BindingResult result) {
	if(result.hasErrors()) {
		return "category.jsp";
	}
	else {
		appService.createCategory(category);
		return "redirect:/";
	}
}
@GetMapping("/product/{id}")
public String productShow(@ModelAttribute("cp")CategoryProduct cp,@PathVariable("id") Long id,Model model) {
	Product product=appService.findProduct(id);
	model.addAttribute("product",product);
	model.addAttribute("categories",appService.categorysNotInProduct(product));
	return "productshow.jsp";
}
@PostMapping("/product/addcat")
public String relation(@ModelAttribute(name="cp")CategoryProduct cp,@RequestParam(name="productId")Long id) {
	Product myproduct=appService.findProduct(id);
	cp.setProduct(myproduct);
	appService.createProductCategory(cp);
	return "redirect:/";
}
}
