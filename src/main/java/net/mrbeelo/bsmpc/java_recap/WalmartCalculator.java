package net.mrbeelo.bsmpc.java_recap;

import java.util.Scanner;

public class WalmartCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in first number:");
        int num1 = scanner.nextInt();

        System.out.println("Type in second number:");
        int num2 = scanner.nextInt();

        System.out.println("Type in operation:");
        char op = scanner.next().charAt(0);

        double result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '%':
                result = num1 % num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    return;
                }
                break;
            default:
                System.out.println("Error: Invalid operation.");
                return;
        }

        // Print the result
        System.out.println("The result is: " + result);
    }
}
