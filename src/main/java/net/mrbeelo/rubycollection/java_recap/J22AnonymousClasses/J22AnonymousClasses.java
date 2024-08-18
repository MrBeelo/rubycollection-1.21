package net.mrbeelo.rubycollection.java_recap.J22AnonymousClasses;

public class J22AnonymousClasses {
    public static void main(String[] args) {
        /* ANONYMOUS CLASSES */

        J22Person nano = new J22Person("Nano", "Attack", 8);

        J22Person manager = new J22Person("John", "Smith", 42) {
            @Override
            public String getFullName() {
                return "Manager " + super.getFullName();
            }
        };

        System.out.println(nano.getFullName());
        System.out.println(manager.getFullName());
    }
}
