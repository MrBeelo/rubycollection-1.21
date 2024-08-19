package net.mrbeelo.bsmpc.java_recap.J24Exceptions;

import java.util.Scanner;

public class J24Exceptions {
    public static void main(String[] args) {
        /* EXCEPTIONS AND TRY & CATCH */

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        // checkForZero(i);

        try {
            checkForZero(i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally");
        }

        System.out.println("This happens always");
    }

    private static void checkForZero(int number) throws J24TestException {
        if (number == 0) {
            throw new J24TestException("NUMBER IS ZERO!");
        }
    }
}
