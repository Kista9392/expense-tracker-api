package com.example.expense.tracker.repository;

import com.example.expense.tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense>findByUserId(Long userId);
    List<Expense>findByUserIdAndCategory(Long userId,String category);
}
