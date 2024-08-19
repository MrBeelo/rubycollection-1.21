package net.mrbeelo.bsmpc.java_recap.J19AccessModifiers;

public class J19AccessModifiers {
    public static void main(String[] args) {
        /* Access Modifiers */

        // used the default constructor
        J19Dog doggo = new J19Dog();
        System.out.println(doggo.name);

        J19Dog bengie = new J19Dog("bengie.png", "Bengie", 7);
        System.out.println(bengie.name);
        System.out.println(bengie.getAge());

        J19Dog gracie = new J19Dog("gracie.png", "Gracie", 5);
        System.out.println(gracie.name);
        System.out.println(gracie.getAge());

        bengie.woof();
        gracie.woof();

        // DOESN'T WORK!
        // bengie.getAge() = 10;
        System.out.println(bengie.getAgeInHumanYears());
    }
}
