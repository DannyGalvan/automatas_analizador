package com.scanner.entities;

public class Token {
    private String name;
    private String attribute;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Token(String name) {
        this.name = name;
    }

    public String toString()
    {
        return "Token: " + name + " Attribute: " + attribute;
    }
}
