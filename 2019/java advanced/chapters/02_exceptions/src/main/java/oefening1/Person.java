package oefening1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private String name;
    private LocalDate birthDate;

    public Person(String name, int year, int month, int day) throws DateTimeException {
        this.name = name;
        if (month >= 1 && month <= 12)  {
            this.birthDate= LocalDate.of(year, month, day);
        } else {
            throw new DateTimeException("Month is incorrect");
        }
    }

    public String getName() {
        return name;
    }

    public int daysTillBirthday() {
        int dayOfYear = LocalDate.now().getDayOfYear();
        int birthDay = birthDate.getDayOfYear();
        if (dayOfYear > birthDay) {
            return birthDate.getYear();
        } else {
            return birthDay - dayOfYear;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person persoon = (Person) o;
        return name.equals(persoon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + ": " + daysTillBirthday() + " dagen tot verjaardag";
    }
}