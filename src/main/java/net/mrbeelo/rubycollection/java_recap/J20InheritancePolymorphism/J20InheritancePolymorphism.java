package net.mrbeelo.rubycollection.java_recap.J20InheritancePolymorphism;

import java.util.ArrayList;
import java.util.List;

public class J20InheritancePolymorphism {
    public static void main(String[] args) {
        /* Inheritance & Polymorphism */

        J20Dog bengie = new J20Dog("bengie.png", "Bengie", 7);
        J20Dog gracie = new J20Dog("gracie.png", "Gracie", 5);

        J20Cat whiskers = new J20Cat("whiskers.png", "Whiskers", 12);

        whiskers.makeSound();
        bengie.makeSound();
        gracie.makeSound();

        J20Animal animal = new J20Dog("jenny.png", "Jenny", 15);
        animal.makeSound();

        List<J20Animal> animals = new ArrayList<>();
        animals.add(bengie);
        animals.add(gracie);
        animals.add(whiskers);

        animals.get(1).makeSound();
    }
}
