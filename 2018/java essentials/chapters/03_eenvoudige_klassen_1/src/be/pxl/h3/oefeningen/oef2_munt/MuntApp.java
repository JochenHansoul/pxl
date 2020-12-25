package be.pxl.h3.oefeningen.oef2_munt;

public class MuntApp {
    public static void main(String[] args) {
        String [] munten = new String[] {"Euro", "roebel", "yen", "dollar", "kroon"};
        double [] koersArray = new double[] {1.111, 2.475, 3.93, 4.429, 5.598};
        for (int i = 0; i < munten.length; i++) {
            Munt munt = new Munt(munten[i], koersArray[i]);
            System.out.println(Math.round(munt.getKoers() * Math.pow(10, Munt.AFRONDING)) / Math.pow(10, Munt.AFRONDING) + " " + munt.getNaam());
            if (i != 0) {
                koersArray[i] /= koersArray[0];
            }
        }
        System.out.println();
        System.out.printf("overzicht koersen tov %s: 1 %s =%n", munten[0], munten[0]);
        for (int j = 1; j < munten.length; j++) {
            Munt munt = new Munt(munten[j], koersArray[j]);
            System.out.println(Math.round(munt.getKoers() * Math.pow(10, Munt.AFRONDING)) / Math.pow(10, Munt.AFRONDING) + " " + munt.getNaam()); // moet double worden gecast
        }
    }
}