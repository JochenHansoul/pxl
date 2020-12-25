package be.pxl.h6.oefeningen.oef1;

public class WerknemerApp {
    public static void main(String[] args) {
        Werknemer werknemer1 = new Werknemer("Hansoul", "Jochen");
        Werknemer werknemer2 = new Werknemer("Hond", "Bert", "schoonmaak", 900);
        Manager manager1 = new Manager("Peter", "Hopkins", "Manager", 1500);

        // printen
        System.out.printf("werknemer 1:\nnaam: %s %s, functie: %s, loon: %d\n", werknemer1.getNaam(), werknemer1.getVoornaam(), werknemer1.getFunctie(), werknemer1.getSalaris());
        System.out.printf("werknemer 2:\nnaam: %s %s, functie: %s, loon: %d\n", werknemer2.getNaam(), werknemer2.getVoornaam(), werknemer2.getFunctie(), werknemer2.getSalaris());
        System.out.printf("manager 1:\nnaam: %s %s, functie: %s, loon: %d, bonus: %d\n", manager1.getNaam(), manager1.getVoornaam(), manager1.getFunctie(), manager1.getSalaris(), manager1.getBonus());

        System.out.println("\nWerknemer 1 print:");
        werknemer1.print();

        System.out.println("\nManager print:");
        manager1.print();

        System.out.println("\nAantallen:");
        System.out.println(Werknemer.getAantal());
        System.out.println(Manager.getAantal());
        System.out.println("procentueel aantal managers " + Manager.getProcAandeelManagers());
    }
}