package be.pxl.h8.opdrachten.opdracht5;

import java.util.Objects;

public class Student {
    private int nr;
    private String naam;

    public Student(int nr, String naam) {
        this.nr = nr;
        this.naam = naam;
    }

    public Student(String naam) {
        this.naam = naam;
    }

    public Student(int nr) {
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }

    public void drukAf() {
        System.out.println("Student  " + naam + " heeft nummer " + nr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return naam.equals(student.naam); // heb hier code wat moeten aanpassen naar naam en slechts 1 variabele
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam);
    }
}