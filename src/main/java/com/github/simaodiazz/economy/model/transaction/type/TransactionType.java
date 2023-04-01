package com.github.simaodiazz.economy.model.transaction.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TransactionType {

    DEPOSIT("Recebeu"),
    WITHDRAW("Enviou"),
    REMOVE("Removeu"),
    GIVE("Adicionou"),
    SET("Definiu"),
    RESET("Resetou");

    private final String text;

}