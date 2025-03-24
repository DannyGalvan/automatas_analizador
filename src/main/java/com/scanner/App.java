package com.scanner;

import com.scanner.entities.*;;

/**
 * App
 *
 */
public class App {
    public static void main(String[] args) {
        String code = "  {     x y { y z } x {  y    z  } g { f h w } j }";

        Scanner scanner = new Scanner();

        scanner.execute(code);
    }
}
