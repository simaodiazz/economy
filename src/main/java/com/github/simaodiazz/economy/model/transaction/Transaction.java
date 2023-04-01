package com.github.simaodiazz.economy.model.transaction;

import com.github.simaodiazz.economy.model.transaction.type.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Transaction {

    private String target;
    private double amount;
    private long date;
    private TransactionType type;

}