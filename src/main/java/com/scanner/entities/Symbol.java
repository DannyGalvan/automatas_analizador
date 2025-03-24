package com.scanner.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Symbol {
    private String name;
    private String type;
    private String lexema;
    private int position;

    public Symbol(String name) {
        this.name = name;
    }
}
