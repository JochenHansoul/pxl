package be.pxl.h2.oefeningen.oef3_bankrekening;

import java.util.Scanner;

public class BankrekeningApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bankrekening rekening1 = new Bankrekening(input);
        rekening1.stort(50);
        System.out.println("Geef een rekeningnummer in");
        String rekeningNr = input.nextLine();
        rekening1.setRekeningnummer(rekeningNr);
        System.out.println("Het saldo is " + rekening1.getSaldo());
        rekening1.stort(10000);
        rekening1.neemOp(200);
        double[] bedragen = new double[] {5, 10.5, 54684, -10.1};
        rekening1.doeVerrichting(bedragen);
        System.out.println();
        Bankrekening rekening2 = new Bankrekening("444-444-555", "Andries Vlaming", 1000, 3, input);
        rekening2.print();
        rekening2.stort(rekening1.getSaldo());
        rekening1.neemOp(rekening1.getSaldo());
        input.close();
    }
}
