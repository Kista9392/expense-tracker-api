package com.example.expense.tracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private String category;
    private LocalDate date ;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
