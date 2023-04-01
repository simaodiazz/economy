package com.github.simaodiazz.economy.model.user;

import com.github.simaodiazz.economy.model.historic.Historic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private UUID uuid;
    private String name;
    private Double balance;
    private Historic historic;

}