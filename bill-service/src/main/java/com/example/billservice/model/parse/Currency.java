package com.example.billservice.model.parse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    private String symbol;
    private String name;
    private String symbol_native;
    private int decimal_digits;
    private int rounding;
    private String code;
    private String name_plural;

}
