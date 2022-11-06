package com.malek.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.malek.travels.models.Expense;
import com.malek.travels.repositories.ExpenseRepository;



@Service
public class ExpenseService {
private final ExpenseRepository expenseRepo;

public ExpenseService(ExpenseRepository expense) {
	this.expenseRepo = expense;
}
public List<Expense> allExpenses(){
	return expenseRepo.findAll();
}
public void createExpense(Expense x) {
	expenseRepo.save(x);
}
public Expense findExpense(Long id) {
    Optional<Expense> optionalExpense = expenseRepo.findById(id);
    if(optionalExpense.isPresent()) {
        return optionalExpense.get();
    } else {
        return null;
    }
}

public void deleteExpense(long x) {
	expenseRepo.deleteById(x);
}
public Expense updateBook(Long id,Expense expense) {
	Expense toUpdate= findExpense(id);
	toUpdate.setAmount(expense.getAmount());
	toUpdate.setDescription(expense.getDescription());;
	toUpdate.setExpenseName(expense.getExpenseName());;
	toUpdate.setVendor(expense.getVendor());;
	expenseRepo.save(toUpdate);
	return null;
}
}
