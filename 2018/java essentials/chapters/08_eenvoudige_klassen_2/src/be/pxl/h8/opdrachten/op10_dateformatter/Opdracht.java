package be.pxl.h8.opdrachten.op10_dateformatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Opdracht {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("geef een datum in in formaat dd/mm/yyyy");
        String datumString = input.nextLine();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate datum = LocalDate.parse(datumString, formatter1);
        // datum afdrukken in formaat yyyy-mm-dd
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(formatter2.format(datum));
        // afdrukken in formaat donderdag 17 januari 2019
        // 1ste manier => formatter gebruiken
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy");
        System.out.println(formatter3.format(datum));
        // 2de manier => printf
        System.out.printf("%tA %td %tB %tY%n", datum, datum, datum, datum);
        System.out.printf("%1$tA %1$td %1$tB %1$tY%n", datum);
        input.close();
    }
}
