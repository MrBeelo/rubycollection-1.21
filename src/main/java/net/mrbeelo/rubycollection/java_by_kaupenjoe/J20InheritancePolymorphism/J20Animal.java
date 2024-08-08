package net.mrbeelo.rubycollection.java_by_kaupenjoe.J20InheritancePolymorphism;

public class J20Animal {
    public String picture;
    protected String name;
    protected int age;

    public J20Animal(String picture, String name, int age) {
        this.picture = picture;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void birthday() {
        age++;
    }

    public void makeSound() {
        System.out.println(this.name + " just made a Sound!");
    }
}
