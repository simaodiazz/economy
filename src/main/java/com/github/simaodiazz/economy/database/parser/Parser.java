package com.github.simaodiazz.economy.database.parser;

public interface Parser<O, D> {

    D parse(O object);
    O unparse(D data);

}