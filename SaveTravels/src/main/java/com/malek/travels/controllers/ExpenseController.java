package com.malek.travels.controllers;

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

import com.malek.travels.models.Expense;
import com.malek.travels.services.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
@GetMapping("/")
public String index(@ModelAttribute("expense") Expense expense,Model model) {
	model.addAttribute("travels",expenseService.allExpenses());
	return "index.jsp";
}
@PostMapping("/process")
public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
    if (result.hasErrors()) {
        return "index.jsp";
    } else {
        expenseService.createExpense(expense);
        return "redirect:/";
    }
}

@GetMapping("/edit/{id}")
public String edit(@PathVariable("id") Long id, Model model) {
    Expense expense = expenseService.findExpense(id);
    model.addAttribute("expense", expense);
    return "edit.jsp";
}

@PutMapping("/edit/{id}")
public String update(@Valid @ModelAttribute("expense") Expense expense,@PathVariable("id") Long id, BindingResult result) {
    if (result.hasErrors()) {
        return "edit.jsp";
    } else {
        expenseService.updateExpense(id, expense);
        return "redirect:/";
    }
}

@DeleteMapping("/expense/{id}")
public String destroy(@PathVariable("id") Long id) {
    expenseService.deleteExpense(id);
    return "redirect:/";
}

@GetMapping("expenses/{id}")
public String show(@PathVariable("id") Long id, Model model) {
    Expense expense = expenseService.findExpense(id);
    model.addAttribute("expense", expense);
    return "show.jsp";
}

}
