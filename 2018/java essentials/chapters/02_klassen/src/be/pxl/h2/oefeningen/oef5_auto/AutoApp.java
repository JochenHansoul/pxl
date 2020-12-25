package be.pxl.h2.oefeningen.oef5_auto;

public class AutoApp {
    public static void main(String[] args) {
        Auto auto1 = new Auto();
        System.out.println(auto1.print());
        Auto auto2 = new Auto("fort", "model", 2010, "groen", 140);
        System.out.println(auto2.getMerk() + auto2.getModel() + auto2.getBouwjaar() + auto2.getKleur() + auto2.getMaximumSnelheid());
        auto2.setModel("hyundai");
        auto2.setMerk("scania");
        auto2.setBouwjaar(2009);
        auto2.setKleur("zwart");
        auto2.setMaximumSnelheid(190);
        System.out.println(auto2.getMerk() + auto2.getModel() + auto2.getBouwjaar() + auto2.getKleur() + auto2.getMaximumSnelheid());
        System.out.println();
        Auto auto3 = new Auto(auto2);
        System.out.println(auto3.print());
        System.out.println(auto1.getTeller());
        // arrays
        String[] merken = new String[] {"merk1", "merk2", "merk3"};
        String[] modellen = new String[] {"model1", "model2", "model3"};
        int[] bouwjaren = new int[] {2001, 2002, 2003};
        String[] kleuren = new String[] {"rood", "groen", "blauw"};
        int[] maximumsnelheden = new int[] {220, 200, 160};
        // constructie en printen arrays
        for (int i = 0; i < merken.length; i++) {
            Auto auto4 = new Auto(merken[i], modellen[i], bouwjaren[i], kleuren[i], maximumsnelheden[i]);
            System.out.println(auto4.print());
        }
        System.out.println(auto3.getTeller());
    }
}
