package com.shamshad.splitwiseclone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private String Description;
    private int amount;

    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;
    @ManyToOne
    private Group group;
    @ManyToOne
    private User addedBy;
}
