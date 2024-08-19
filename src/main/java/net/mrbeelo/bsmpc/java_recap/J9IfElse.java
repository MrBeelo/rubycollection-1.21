package net.mrbeelo.bsmpc.java_recap;

import java.util.Scanner;

public class J9IfElse {
    public static void main(String[] args) {
        /* IF AND ELSE STATEMENTS  */

        int exam1 = 65;
        int exam2 = 51;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Results for Exam 1: ");
        exam1 = scanner.nextInt();
        System.out.println("Results for Exam 2: ");
        exam2 = scanner.nextInt();

        if(exam1 >= 50) {
            System.out.println("You have passed Exam 1");
        } else {
            System.out.println("You have FAILED Exam 1");
        }

        if(exam2 >= 50) {
            System.out.println("You have passed Exam 2");
        } else {
            System.out.println("You have FAILED Exam 2");
        }

        if(exam1 >= 50 && exam2 >= 50) {
            System.out.println("You have passed the CLASS");
        } else {
            System.out.println("You have FAILED the CLASS");
        }
    }
}
