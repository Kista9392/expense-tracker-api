package com.example.expense.tracker.controller;

import com.example.expense.tracker.entity.Expense;
import com.example.expense.tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class expenseController {
    @Autowired
    private ExpenseService expenseService;
    @PostMapping
    public Expense createExpense(@RequestBody Expense expense){
        return expenseService.saveExpense(expense);
    }
    @GetMapping("/")
    public String test() {
        return "App is working 🚀";
    }
    @GetMapping
    public List<Expense>getAllExpenses(){
        return expenseService.getAllExpenses();
    }
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);

    }
    @GetMapping("/user/{userId}")
    public List<Expense> getExpenseByUser(@PathVariable Long userId){
        return  expenseService.getExpensesByUser(userId);
    }
    @GetMapping("/user/{userId}/total")
    public Double getTotalExpense(@PathVariable Long userId) {
        return expenseService.getTotalExpenseByUser(userId);
    }
    @GetMapping("/user/{userId}/category/{category}")
    public List<Expense>getexpensesbyidandcategory(@PathVariable Long userId,@PathVariable String category){
        return expenseService.getExpenseByUserIdAndCategory(userId,category);
    }
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id){
        return expenseService.getExpenseById(id);
    }

}
