package be.pxl.h1.voorbeelden;

public class Opdracht13_tabel {
    public static void main(String[] args) {
        // array 4 rijen en 6 kolommen
        int [][] array2d = new int[4][6];
        // arrey rij per rij invullen
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[i].length; j++) {
                array2d[i][j] = (i + 1) * (j + 1);
            }
        }
        // druk getallen af, dit is een soort van verwijzing naar de plaatst waar de getallen staan
        for (int [] rij : array2d) {
            for (int getal : rij) {
                System.out.print(getal + "\t");
            }
            System.out.println();
        }
        System.out.println();
        // extra: bereken de som per kolom en druk af
        for (int j = 0; j < array2d[0].length; j++) {
            int som = 0;
            for (int i = 0; i < array2d.length; i++) {
                som += array2d[i][j];
            }
            System.out.printf("De som van kolom nr %d = %d %n", j + 1, som);
        }
    }
}
