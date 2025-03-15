package com.scanner;

import com.scanner.entities.*;;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String code = "{ x y { y z }      }";

        Scanner scanner = new Scanner();

        scanner.execute(code);
    }
}
