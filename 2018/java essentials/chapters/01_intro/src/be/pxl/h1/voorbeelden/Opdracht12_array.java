package be.pxl.h1.voorbeelden;

public class Opdracht12_array {
    public static void main(String[] args) {
        // array let 20 getallen aanmaken
        int [] arrayVeelvoud = new int[20]; // nu aangemaakt en overal staat er een NULL
        for (int i = 0; i < arrayVeelvoud.length; i++) {
            arrayVeelvoud[i] = i * 7;
        }
        // afdrukken met for each lus
        for (int getal : arrayVeelvoud) {
            System.out.print(getal + " ");
        }
        System.out.println();
        int [] array = new int[10];
        for (int i = 0; i < array.length; i += 1) {
            array[i] = i * 2 + 1;
        }
        // alternatieve manier
        /*for (int i = 1; i < array.length; i += 2) {
            array[i / 2] = i;
        }*/
        // afdrukken
        for (int getal : array) {
            System.out.print(getal + " ");
        }
        System.out.println();
        // omgekeerde volgorde afdrukken
        for (int i = array.length -1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
