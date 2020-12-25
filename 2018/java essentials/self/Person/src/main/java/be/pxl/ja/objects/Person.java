package be.pxl.ja.objects;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person() {
        this("unknown", "unknown");
    }

    public Person(String firstName, String lastName) {
        this(firstName, lastName, 0);
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = Math.max(age, 0);
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
