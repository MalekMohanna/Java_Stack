package com.malek.travels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.malek.travels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
List<Expense> findAll();
}
