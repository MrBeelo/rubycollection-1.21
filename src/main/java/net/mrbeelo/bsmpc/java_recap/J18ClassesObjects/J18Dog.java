package net.mrbeelo.bsmpc.java_recap.J18ClassesObjects;

public class J18Dog {
    // Adding some fields
    public String picture;
    public String name;
    public int age;

    // Default Constructor
    public J18Dog() {

    }

    public J18Dog(String picture, String name, int age) {
        this.picture = picture;
        this.name = name;
        this.age = age;
    }

    // Method
    public void woof() {
        System.out.println(this.name + " just woofed!");
    }
}
