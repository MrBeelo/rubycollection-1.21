package net.mrbeelo.rubycollection.java_recap.J21InterfacesAbstractClasses;

public class J21Dog extends J21Animal implements J21IPettable {
    public static final int dogToHumanYearMultiplier = 7;

    public J21Dog(String picture, String name, int age) {
        super(picture, name, age);
    }

    public int getAgeInHumanYears() {
        return age * dogToHumanYearMultiplier;
    }

    @Override
    public void makeSound() {
        System.out.println(this.name + " just woofed!");
    }

    @Override
    public void pet() {
        System.out.println(this.name + " was scratched behind the ears!");
    }
}
