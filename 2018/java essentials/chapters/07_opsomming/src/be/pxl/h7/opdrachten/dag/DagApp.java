package be.pxl.h7.opdrachten.dag;

public class DagApp {
    public static void main(String[] args) {
        for (Dag dag : Dag.values()) { // klassemethode gebruiken die wet net hebben gemaakt voor weekdagen
            String beschrijving;
            if (dag.getWeekdag()) { // dit is een boolean, true is weekdag
                beschrijving = "Dag in de week";
            } else {
                beschrijving = "Dag in het weekend";
            }
            System.out.println(dag.name() + " plaats in de opsomming " + dag.ordinal() + beschrijving);
        }
        // opdracht 4
        Dag dag1 = Dag.WOENSDAG;
        Dag dag2 = Dag.ZONDAG;
        int aantal;
        if (dag1.equals(dag2)) {
            System.out.println("de 2 dagen zijn gelijk");
        } else {
            System.out.println("de 2 dagen zijn verschillend");
        }
        if (dag1.ordinal() < dag2.ordinal()) {
            System.out.println("dag1 komt voor dag2");
            aantal = dag2.ordinal() - dag1.ordinal();
        } else if (dag1.ordinal() == dag2.ordinal()) {
            System.out.println("dag1 en dag2 zijn gelijk");
            aantal = 0;
        } else {
            System.out.println("dag2 komt na dag1");
            aantal = dag1.ordinal() - dag2.ordinal();
        }
        System.out.printf("het aantal dagen tussen %s en %s is %d%n", dag1, dag2, aantal);
    }
}
