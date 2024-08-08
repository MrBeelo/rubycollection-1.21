package net.mrbeelo.rubycollection.java_by_kaupenjoe.J19AccessModifiers;

public class J19Dog {
    // Adding some fields
    public String picture;
    protected String name;
    private int age;
    public static final int dogToHumanYearMultiplier = 7;

    // public, protected, private
    // static, final


    public int getAge() {
        return age;
    }

    // Default Constructor
    public J19Dog() {

    }

    public void birthday() {
        age++;
    }

    public int getAgeInHumanYears() {
        return age * dogToHumanYearMultiplier;
    }

    public J19Dog(String picture, String name, int age) {
        this.picture = picture;
        this.name = name;
        this.age = age;
    }

    // Method
    public void woof() {
        System.out.println(this.name + " just woofed!");
    }
}
