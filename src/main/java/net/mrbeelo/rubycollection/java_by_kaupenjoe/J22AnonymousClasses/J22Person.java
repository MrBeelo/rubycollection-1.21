package net.mrbeelo.rubycollection.java_by_kaupenjoe.J22AnonymousClasses;

public class J22Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;

    public J22Person(String firstName, String middleName, String lastName, int age) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isOlderThan(int olderThan) {
        return age >= olderThan;
    }

    public J22Person(String firstName, String lastName, int age) {
        this(firstName, "", lastName, age);
    }
}
