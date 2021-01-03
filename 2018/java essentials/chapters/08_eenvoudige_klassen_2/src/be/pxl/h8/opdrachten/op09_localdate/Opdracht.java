package be.pxl.h8.opdrachten.op09_localdate;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Opdracht {
    public static void main(String[] args) {
        LocalDate geboortedatum = LocalDate.of(2000, 6, 16);
        LocalDate vandaag = LocalDate.now();
        Period levensduur = Period.between(geboortedatum, vandaag);
        System.out.printf("%d jaren %d maanden %d dagen%n", levensduur.getYears(), levensduur.getMonths(), levensduur.getDays());
        System.out.println("leeeftijd uitgedrukt in maanden " + ChronoUnit.MONTHS.between(geboortedatum, vandaag));
    }
}
