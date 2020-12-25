package be.pxl.h1.voorbeelden;
/* maak programma dat eenheid meter omzet naar voet
Toon de waarden van 1 meter tem 20 meter (toename 0.5 meter)
en de overeenkomstige waarden in voet;
Zorg dat slechts 2 cijfers na de komma getoond worden dat dat alle getallen mooi uitgelijnd zijn.
1 meter = 3.2808399 voet
 */

public class Opdracht12_voet {
    public static void main(String[] args) {
        for (double meter = 1; meter <= 20; meter += 0.5) {
            double voet = meter * 3.2808399;
            System.out.printf("%.2f %.2f %n", meter, voet); /* .2 voor cijfers na komma, %f voor opmaak */
        }
    }
}
