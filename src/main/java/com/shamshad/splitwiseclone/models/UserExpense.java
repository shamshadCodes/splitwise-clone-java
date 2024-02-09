package com.shamshad.splitwiseclone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel{
    private int amount;

    @Enumerated
    private UserExpenseType userExpenseType;
    @ManyToOne
    private User user;
    @ManyToOne
    private Expense expense;
}
