package be.pxl.h8.opdrachten.opdr05_lists;

import java.util.ArrayList;

public class KlasApp {
    public static void main(String[] args) {
        ArrayList<Student> lijstStudenten = new ArrayList<Student>(); // lijst met student objecten
        lijstStudenten.add(new Student(10, "Erik"));
        lijstStudenten.add(new Student(20, "Dirk"));
        lijstStudenten.add(new Student(30, "Anne"));

        System.out.println("\nOorspronkelijke klaslijst");
        for (Student student : lijstStudenten) {
            student.drukAf();
        }

        lijstStudenten.add(1, new Student(22, "Piet"));
        lijstStudenten.remove(3); // Anne wordt verwijderd
        lijstStudenten.set(0, new Student(11, "Ilse"));

        System.out.println("\nGewijzigde klaslijst");
        for (Student student : lijstStudenten) {
            student.drukAf();
        }

        // gaat wel degelijk in klasse student opzoeken maar equels methode moet herschreven worden door enkel als namen overeenkomen
        System.out.println();
        int positie = lijstStudenten.indexOf(new Student("Ilse"));
        if (positie == -1) {
            System.out.println("Ilse komt niet voor in de arraylist");
        } else {
            Student gevonden = lijstStudenten.get(positie);
            System.out.println("Opzoeking in de arraylist levert op : ");
            gevonden.drukAf();
        }
    }
}
