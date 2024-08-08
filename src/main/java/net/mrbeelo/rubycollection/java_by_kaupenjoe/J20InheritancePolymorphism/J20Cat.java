package net.mrbeelo.rubycollection.java_by_kaupenjoe.J20InheritancePolymorphism;

public class J20Cat extends J20Animal {
    public J20Cat(String picture, String name, int age) {
        super(picture, name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(this.name + " just meowed!");
    }
}
