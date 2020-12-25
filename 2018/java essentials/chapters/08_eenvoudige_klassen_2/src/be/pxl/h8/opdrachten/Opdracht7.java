package be.pxl.h8.opdrachten;

import java.time.DayOfWeek;
import java.util.Scanner;

public class Opdracht7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("geef een dagnummer in");
        int dagnummer = input.nextInt();
        System.out.println("geef een aantal dagen in");
        int aantal = input.nextInt();
        DayOfWeek dag = DayOfWeek.of(dagnummer);
        System.out.println("het is een " + dag);
        DayOfWeek dag2 = dag.plus(aantal);
        System.out.printf("%d dagen later is het een %s", aantal, dag2 );
        input.close();
    }
}
