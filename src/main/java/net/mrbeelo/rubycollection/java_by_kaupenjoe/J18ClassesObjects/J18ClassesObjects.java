package net.mrbeelo.rubycollection.java_by_kaupenjoe.J18ClassesObjects;

public class J18ClassesObjects {
    public static void main(String[] args) {
        /* Classes and Objects */

        // used the default constructor
        J18Dog doggo = new J18Dog();
        System.out.println(doggo.name);

        J18Dog bengie = new J18Dog("bengie.png", "Bengie", 7);
        System.out.println(bengie.name);
        System.out.println(bengie.age);

        J18Dog gracie = new J18Dog("gracie.png", "Gracie", 5);
        System.out.println(gracie.name);
        System.out.println(gracie.age);

        bengie.woof();
        gracie.woof();

        bengie.age = 10;
        System.out.println(bengie.age);
    }
}

