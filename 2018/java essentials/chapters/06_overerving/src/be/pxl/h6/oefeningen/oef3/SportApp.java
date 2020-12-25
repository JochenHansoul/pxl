package be.pxl.h6.oefeningen.oef3;

public class SportApp {
    public static void main(String[] args) {
        // arrays sporters
        String[] namen = new String[]{"Hansoul", "Kleisters", "Henine", "Tiger", "Lebron", "Christian", "lukaku", "de bruin", "Marouane", "Hazard"};
        String[] voornamen = new String[] {"Jochen", "Kim", "justin", "Woods", "James", "Ronaldoo", "Romelu", "Kevin", "Fellaini", "Eden"};
        String[] omschrijvingen = new String[] {"golf", "Tennis", "tennis", "golf", "basketball", "voetballer", "voetballer", "voetballer", "voetballer", "voetballer"};
        // arrays voetballers
        String[] clubs = new String[] {"Rode Duivels", "Rode Duivels", "Rode Duivels", "Rode Duivels", "Rode Duivels"};
        String[] obstellingen = new String[] {"middenvelder", "aanvaller", "verdediger", "middenvelder", "aanvaller"};
        // array objecten aanmaken en eigenschappen toevoegen
        Sporter[] arraySporters = new Sporter[namen.length];
        for (int i = 0; i < namen.length - clubs.length; i++) { // sporters
            arraySporters[i] = new Sporter(namen[i], voornamen[i], omschrijvingen[i]);
        }
        for (int i = 0; i < namen.length - clubs.length; i++) { // voetballers
            arraySporters[i + namen.length - clubs.length] = new Voetballer(namen[i + namen.length - clubs.length], voornamen[i + namen.length - clubs.length], clubs[i], obstellingen[i]);
        }
        // afprinten
        System.out.println("overzicht sporters (behalve voetballers)");
        for (Sporter s : arraySporters) {
            if (! (s instanceof Voetballer)) {
                s.print();
            }
        }
        System.out.println();
        System.out.println("overzicht voetballers volgens obstelling");
        for (String obstelling : Voetballer.getArrayObestellingen()) {
            System.out.println("*** " + obstelling + " ***");
            for (Sporter s : arraySporters) {
                if (s instanceof Voetballer && ((Voetballer) s).getObstelling().equals(obstelling)) {
                    s.print();
                }
            }
        }
        // afprinten voetballers
        /*System.out.println("overzicht voetballers volgens obstelling");
        int teller = 0;
        int obstelling = 0;
        while (teller < voetballers.length) {
            System.out.println("*** " + Voetballer.getArrayObestellingen()[obstelling] + " ***");
            for (int i = 0; i < clubs.length; i++) {
                if (voetballers[i].getObstelling().equals(Voetballer.getArrayObestellingen()[obstelling])) {
                    voetballers[i].print();
                    teller++;
                }
            }
            obstelling++;
        }*/
    }
}
