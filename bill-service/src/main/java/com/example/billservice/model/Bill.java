package com.example.billservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bill {
    private int id;
    private String personName;
    private int amount;
}
