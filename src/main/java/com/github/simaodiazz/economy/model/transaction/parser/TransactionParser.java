package com.github.simaodiazz.economy.model.transaction.parser;

import com.github.simaodiazz.economy.database.parser.Parser;
import com.github.simaodiazz.economy.model.transaction.Transaction;
import com.github.simaodiazz.economy.model.transaction.type.TransactionType;

public class TransactionParser implements Parser<Transaction, String> {

    @Override
    public String parse(Transaction transaction) {

        return transaction.getTarget() +
                ":" +
                transaction.getAmount() +
                ":" +
                transaction.getType() +
                ":" +
                transaction.getDate() +
                "@";
    }

    @Override
    public Transaction unparse(String data) {

        String[] split = data.split(":");

        String target = split[0];
        double amount = Double.parseDouble(split[1]);
        TransactionType type = TransactionType.valueOf(split[2]);
        long date = Long.parseLong(split[3].replace("@", ""));

        return new Transaction(target, amount, date, type);
    }
}