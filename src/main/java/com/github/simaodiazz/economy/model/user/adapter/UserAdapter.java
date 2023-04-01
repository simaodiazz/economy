package com.github.simaodiazz.economy.model.user.adapter;

import com.github.simaodiazz.economy.model.historic.parser.HistoricParser;
import com.github.simaodiazz.economy.database.adapter.Adapter;
import com.github.simaodiazz.economy.model.historic.Historic;
import com.github.simaodiazz.economy.model.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserAdapter implements Adapter<User> {

    private final HistoricParser historicParser;

    public UserAdapter() {
        this.historicParser = new HistoricParser();
    }

    @Override
    public User adapt(ResultSet resultSet) throws SQLException {

        UUID uuid = UUID.fromString(resultSet.getString("uuid"));
        String name = resultSet.getString("name");
        double balance = resultSet.getDouble("balance");
        Historic historic = historicParser.unparse("historic");

        return new User(name, uuid, balance, historic);
    }
}