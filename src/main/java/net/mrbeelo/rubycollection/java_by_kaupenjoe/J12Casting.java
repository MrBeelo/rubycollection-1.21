package net.mrbeelo.rubycollection.java_by_kaupenjoe;

public class J12Casting {
    public static void main(String[] args) {
        /* CASTING (or converting data types between each other)  */

        int loan = 750;
        float interestRate = 0.0525f;

        float interest = (float)loan * interestRate;
        System.out.println(interest);
    }
}
