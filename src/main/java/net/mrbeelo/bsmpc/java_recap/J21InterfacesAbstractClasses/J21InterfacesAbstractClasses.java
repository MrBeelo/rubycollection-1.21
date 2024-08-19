package net.mrbeelo.bsmpc.java_recap.J21InterfacesAbstractClasses;

import java.util.ArrayList;
import java.util.List;

public class J21InterfacesAbstractClasses {
    public static void main(String[] args) {
        /* INTERFACES AND ABSTRACT */

        J21Dog bengie = new J21Dog("bengie.png", "Bengie", 7);
        J21Dog gracie = new J21Dog("gracie.png", "Gracie", 5);

        J21Cat whiskers = new J21Cat("whiskers.png", "Whiskers", 12);

        whiskers.makeSound();
        bengie.makeSound();
        gracie.makeSound();

        J21Animal animal = new J21Dog("jenny.png", "Jenny", 15);
        animal.makeSound();

        List<J21Animal> animals = new ArrayList<>();
        animals.add(bengie);
        animals.add(gracie);
        animals.add(whiskers);

        animals.get(1).makeSound();

        // J21Animal a = new J21Animal("x.png", "X", 10);

        List<J21IPettable> pets = new ArrayList<>();
        pets.add(bengie);
        pets.add(whiskers);

        pets.get(1).pet();

    }
}
