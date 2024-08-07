package net.mrbeelo.rubycollection.java_docs.assignments;

import java.util.Scanner;

public class A1TriviaGame {
    public static void main(String[] args) {
        /* ASSIGNMENT 1 */

        /*
         * CREATE A SIMPLE TRIVIA GAME
         *
         * Define (at least) three questions with three answers.
         * Prompt the User the type in their answer using the Scanner, you've seen in the output/input video
         * Then use if/else statements to check if the answer from the user is correct! And output that they were.
         * If they were wrong, tell the user and output the correct answer.
         * Increment a points total each time the user is correct and at the end make a unique output for each
         * score the user might have (0 to 3)
         *
         * IMPORTANT TIPS:
         * 1. When reading in Strings from the user use scanner.next() (NOT scanner.nextLine())
         * 2. When you have an answer and input that are both strings you will have to use:
         *    userInput.equals(answer) instead of userInput == answer
         */

        //MY ATTEMPT
        int points = 0;
        String firstQuestion = "Chinese";
        String secondQuestion = "BSTCHLD";
        String thirdQuestion = "Dead";

        Scanner scanner = new Scanner(System.in);

        System.out.println("First Question: English or Spanish?");
         String firstInput = scanner.next();

        if (firstInput.equals(firstQuestion)) {
            System.out.println("Correct, it was " + firstQuestion + ", i give u point :)");
            points += 1;
        } else {
            System.out.println("You're stupid. Answer was: " + firstQuestion);
        }

        System.out.println("Second Question: Who painted the Portrait Le Cumme?");
        String secondInput = scanner.next();

        if (secondInput.equals(secondQuestion)) {
            System.out.println("Correct, it was " + secondQuestion + ", i give u point :)");
            points += 1;
        } else {
            System.out.println("You're stupid. Answer was: " + secondQuestion);
        }

        System.out.println("Third Question: Do yo mama know u gay?");
        String thirdInput = scanner.next();

        if (thirdInput.equals(thirdQuestion)) {
            System.out.println("Correct, it was " + thirdQuestion + ", i give u point :)");
            points += 1;
        } else {
            System.out.println("You're stupid. Answer was: " + thirdQuestion);
        }

        if (points == 3) {
            System.out.println("Ayyyy you got " + points + " points! That's average.");
        } else {
            System.out.println("You only got " + points + " points which means you a FAILURE!!!");
        }
    }
}
