package net.mrbeelo.bsmpc.java_recap.J21InterfacesAbstractClasses;

public abstract class J21Animal {
    public String picture;
    protected String name;
    protected int age;

    public J21Animal(String picture, String name, int age) {
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

    public abstract void makeSound();
}
