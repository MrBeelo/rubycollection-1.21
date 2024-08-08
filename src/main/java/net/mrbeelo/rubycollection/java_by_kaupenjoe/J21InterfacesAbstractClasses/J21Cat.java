package net.mrbeelo.rubycollection.java_by_kaupenjoe.J21InterfacesAbstractClasses;

public class J21Cat extends J21Animal implements J21IPettable {
    public J21Cat(String picture, String name, int age) {
        super(picture, name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(this.name + " just meowed!");
    }

    @Override
    public void pet() {
        System.out.println(this.name + " was pet!");
    }
}
