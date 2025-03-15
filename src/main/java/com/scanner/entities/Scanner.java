package com.scanner.entities;

public class Scanner {
    char[] listaCaracteres = new char[100];
    private int column;
    private int state;
    private char symbol = ' ';

    public Scanner() {
        this.column = 0;
        this.state = 0;
    }

    public void execute(String code) {
        listaCaracteres = code.toCharArray();

        while (this.column <= listaCaracteres.length) {
            getBlock();
        }
    }

    private Token getBlock() {
        Token token = new Token("BLOCK");

        String text = "";
        symbol = this.column == 0 ? ' ' : symbol;
        this.state = 0;

        try {
            while (true) {
                switch (this.state) {
                    case 0:
                        symbol = nextChar();
                        if (symbol == '{') {
                            state = 1;
                        } else if (symbol == '}') {
                            state = 2;
                        } else if (Character.isLetter(symbol)) {
                            state = 3;
                        } else if (symbol == ' ' || symbol == '\n' || symbol == '\t')
                            state = 5;
                        else {
                            fallo();
                            return null;
                        }
                        break;
                    case 1:
                        token.setAttribute("{");
                        System.out.println("{");
                        return token;
                    case 2:
                        token.setAttribute("}");
                        System.out.println("}");
                        return token;
                    case 3:
                        if (Character.isLetterOrDigit(symbol)) {
                            text += symbol;
                            state = 3;
                            symbol = nextChar();
                        } else {
                            state = 4;
                            this.column--;
                        }
                        break;
                    case 4:
                        token.setAttribute(text);
                        System.out.println(text);
                        return token;
                    case 5:
                        if (symbol == ' ' || symbol == '\n' || symbol == '\t') {
                            text += "DELIM ";
                            state = 5;
                            symbol = nextChar();
                        } else {
                            state = 6;
                            this.column--;
                        }
                        break;
                    case 6:
                        token.setAttribute("DELIM");
                        System.out.println(text);
                        return token;
                    default:
                        fallo();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Fin del Texto");
            return null;
        }

    }

    private void getThen() {
        char symbol = ' ';

        while (true) {
            switch (this.state) {
                case 0:
                    symbol = nextChar();
                    if (symbol == 't') {
                        state = 1;
                    } else {
                        fallo();
                        return;
                    }
                    break;
                case 1:
                    symbol = nextChar();
                    if (symbol == 'h') {
                        state = 2;
                    } else {
                        fallo();
                        return;
                    }
                    break;
                case 2:
                    symbol = nextChar();
                    if (symbol == 'e') {
                        state = 3;
                    } else {
                        fallo();
                        return;
                    }
                    break;
                case 3:
                    symbol = nextChar();
                    if (symbol == 'n') {
                        state = 4;
                    } else {
                        fallo();
                        return;
                    }
                    break;
                case 4:
                    symbol = nextChar();
                    if (!Character.isLetterOrDigit(symbol)) {
                        state = 5;
                    } else {
                        fallo();
                        return;
                    }
                    break;
                case 5:
                    System.out.println("Se encontró 'then'");
                    return;
                default:
                    System.out.println("Fin del Texto");
                    return;
            }
        }
    }

    private Token getOpRel() {
        Token token = new Token("oprel");

        char symbol = ' ';

        try {
            while (true) {
                switch (this.state) {
                    case 0:
                        symbol = nextChar();
                        if (symbol == '<') {
                            state = 1;
                        } else if (symbol == '=') {
                            state = 5;
                        } else if (symbol == '>') {
                            state = 6;
                        } else {
                            fallo();
                            return null;
                        }
                        break;
                    case 1:
                        symbol = nextChar();
                        if (symbol == '=') {
                            state = 2;
                        } else if (symbol == '>') {
                            state = 3;
                        } else {
                            state = 4;
                        }
                        break;
                    case 2:
                        token.setAttribute("LE");
                        System.out.println("LE");
                        return token;
                    case 3:
                        token.setAttribute("NE");
                        System.out.println("NE");
                        return token;
                    case 4:
                        column--;
                        token.setAttribute("LT");
                        System.out.println("LT");
                        return token;
                    case 5:
                        token.setAttribute("EQ");
                        System.out.println("EQ");
                        return token;
                    case 6:
                        symbol = nextChar();
                        if (symbol == '=') {
                            state = 7;
                        } else {
                            state = 8;
                        }
                        break;
                    case 7:
                        token.setAttribute("GE");
                        System.out.println("GE");
                        return token;
                    case 8:
                        column--;
                        token.setAttribute("GT");
                        System.out.println("GT");
                        return token;
                    default:
                        fallo();
                        break;
                }
            }
        } catch (Exception e) {
            fallo();
            return null;
        }

    }

    private void fallo() {
        System.out.println("Error");
    }

    private char nextChar() {
        return listaCaracteres[this.column++];
    }
}
