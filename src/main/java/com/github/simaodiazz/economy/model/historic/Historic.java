package com.github.simaodiazz.economy.model.historic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.github.simaodiazz.economy.model.transaction.Transaction;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Historic {

    private ArrayList<Transaction> transactions;

}