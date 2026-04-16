package com.example.expense.tracker.service;

import com.example.expense.tracker.entity.Expense;
import com.example.expense.tracker.entity.User;
import com.example.expense.tracker.repository.ExpenseRepository;
import com.example.expense.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserRepository userRepository;
    public Expense saveExpense(Expense expense){
        Long userId=expense.getUser().getId();
        User user =userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        expense.setUser(user);
        return expenseRepository.save(expense);
    }
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }
    public void deleteExpense(Long id){
        if(!expenseRepository.existsById(id)){
            throw new RuntimeException("expense not found");
        }
        expenseRepository.deleteById(id);
    }
    public List<Expense>getExpensesByUser(Long userId){
        return expenseRepository.findByUserId(userId);

    }
    public Double getTotalExpenseByUser(Long userId) {
        List<Expense> expenses = expenseRepository.findByUserId(userId);

        Double total = 0.0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }
    public List<Expense>getExpenseByUserIdAndCategory(Long userId,String category){
        return expenseRepository.findByUserIdAndCategory(userId,category);
    }
    public Expense updateExpense(Long id, Expense newExpense) {
        Expense existing = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        existing.setAmount(newExpense.getAmount());
        existing.setCategory(newExpense.getCategory());
        existing.setDate(newExpense.getDate());
        existing.setDescription(newExpense.getDescription());

        return expenseRepository.save(existing);
    }
    public Expense getExpenseById(Long id){
        return expenseRepository.findById(id).orElseThrow(()->new RuntimeException("Expense not found"));
    }




}
