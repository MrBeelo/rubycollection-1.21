package net.mrbeelo.rubycollection.java_recap.J20InheritancePolymorphism;

public class J20Dog extends J20Animal {
    public static final int dogToHumanYearMultiplier = 7;

    public J20Dog(String picture, String name, int age) {
        super(picture, name, age);
    }

    public int getAgeInHumanYears() {
        return age * dogToHumanYearMultiplier;
    }

    @Override
    public void makeSound() {
        System.out.println(this.name + " just woofed!");
    }
}
