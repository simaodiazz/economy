package com.github.simaodiazz.economy.model.historic.parser;

import com.github.simaodiazz.economy.database.parser.Parser;
import com.github.simaodiazz.economy.model.historic.Historic;
import com.github.simaodiazz.economy.model.transaction.Transaction;
import com.github.simaodiazz.economy.model.transaction.parser.TransactionParser;

import java.util.ArrayList;

public class HistoricParser implements Parser<Historic, String> {

    private final TransactionParser transactionParser;

    public HistoricParser() {
        transactionParser = new TransactionParser();
    }

    @Override
    public String parse(Historic historic) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <= historic.getTransactions().size(); i++) {

            Transaction transaction = historic.getTransactions().get(i);

            String data = transactionParser.parse(transaction);

            stringBuilder.append(data);

        }

        return stringBuilder.toString();
    }

    @Override
    public Historic unparse(String data) {

        Historic historic = new Historic();
        historic.setTransactions(new ArrayList<>());

        String[] split = data.split("@");

        for (String s : split) {

            Transaction transaction = transactionParser.unparse(s);

            historic.getTransactions().add(transaction);

        }

        return historic;
    }
}