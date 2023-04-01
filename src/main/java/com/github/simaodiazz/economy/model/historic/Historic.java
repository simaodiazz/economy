package com.github.simaodiazz.economy.model.historic;

import com.github.simaodiazz.economy.model.transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class Historic {

    private ArrayList<Transaction> transactions;

    public Historic() {
        transactions = new ArrayList<>();
    }
}