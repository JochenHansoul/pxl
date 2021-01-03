package be.pxl.h8.opdrachten.op08_birthdate;

import java.time.LocalDate;

public class Opdracht8_birthdate {
    public static void main(String[] args) {
        LocalDate geboorteDatum = LocalDate.of(1997, 5, 22);
        // hoeveelste dag v/h jaar
        System.out.println("dagnummer " + geboorteDatum.getDayOfYear());
        // welke dag v/d week
        System.out.println("Dit was op een " + geboorteDatum.getDayOfWeek());
        // schrikkeljaar
        System.out.println("schrikkeljaar? " + geboorteDatum.isLeapYear());
    }
}
