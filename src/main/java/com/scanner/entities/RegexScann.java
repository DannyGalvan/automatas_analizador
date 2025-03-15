package com.scanner.entities;

public class RegexScann {
    // regex to match a number oprel number
    private final String OPREL = "([0-9]+)(<|>|<=|>=|==|!=)([0-9]+)";
    // regex to match a number
    private final String NUMBER = "[0-9]+";
    // regex to match a operator
    private final String OPERATOR = "(<|>|<=|>=|==|!=)";

    public void execute(String code) {
        // remove all whitespaces
        code = code.replaceAll("\\s", "");

        // check if the code matches the regex
        if (code.matches(OPREL)) {
            System.out.println("Matched");
            // get the numbers and the operator
            String[] parts = code.split("(<|>|<=|>=|==|!=)");
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[1]);
            // get the operator between the numbers
            parts = code.split("[0-9]+");
            String op = parts[1];

            System.out.println("The first numbert is : " + num1);
            System.out.println("The second numbert is : " + num2);
            System.out.println("The operator is : " + op);

            // check the operator
            if (op.equals("<")) {
                System.out.println("The result is : " + (num1 < num2));
            } else if (op.equals(">")) {
                System.out.println("The result is : " + (num1 > num2));
            } else if (op.equals("<=")) {
                System.out.println("The result is : " + (num1 <= num2));
            } else if (op.equals(">=")) {
                System.out.println("The result is : " + (num1 >= num2));
            } else if (op.equals("==")) {
                System.out.println("The result is : " + (num1 == num2));
            } else if (op.equals("!=")) {
                System.out.println("The result is : " + (num1 != num2));
            } else {
                System.out.println("Invalid operator");
            }
        } else if (code.matches(NUMBER)) {
            System.out.println("Matched");
            System.out.println("The number is : " + code);
        } else if (code.matches(OPERATOR)) {
            System.out.println("Matched");
            System.out.println("The operator is : " + code);
        } else {
            System.out.println("Not matched");
        }
    }
}
