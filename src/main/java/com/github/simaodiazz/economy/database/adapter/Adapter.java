package com.github.simaodiazz.economy.database.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Adapter<O> {

    O adapt(ResultSet resultSet) throws SQLException;

}