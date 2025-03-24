package com.scanner.entities;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Environment {
    private Map<String, Symbol> table = new HashMap<>();
    private Environment parent;

    public Environment(Environment parent) {
        this.parent = parent;
    }

    public Map<String, Symbol> getTable() {
        return this.table;
    }

    public Environment getParent() {
        return parent;
    }

    public void put(String key, Symbol value) {
        table.put(key, value);
    }

    public Symbol get(String key) {

        for (Environment e = this; e != null; e = e.getParent()) {
            Symbol hasSymbol = e.table.get(key);

            if (hasSymbol != null) {
                return hasSymbol;
            }
        }

        return null;
    }

    public void seeData() {
        System.out.println("Mostrar Datos Tabla");
        this.table.forEach((key, value) -> System.out.println("llave: " + key + "valor: " + value));
    }
}
