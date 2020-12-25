package be.pxl.h2.oefeningen.oef3_bankrekening;

import java.util.Scanner;

public class Bankrekening {
    Scanner input;
    private String rekeningnummer;
    private String naam;
    private double saldo;
    private double rentepercentage;

    // constructors
    public Bankrekening(Scanner keyboard) {
        this("geen", "onbekend", 0, 1.2, keyboard);
    }
    public Bankrekening(String rekeningnummer, String naam, double saldo, double rentepercentage, Scanner keyboard) {
        this.rekeningnummer = rekeningnummer;
        this.naam = naam;
        if (saldo < 0) {
            this.saldo = 0;
        } else {
            this.saldo = saldo;
        }
        if (rentepercentage < 0) {
            this.rentepercentage = 0;
        } else {
            this.rentepercentage = rentepercentage;
        }
        input = keyboard;
    }

    // setters
    public void setnaam(String naam) {
        this.naam = naam;
    }
    public void setRekeningnummer(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    // getters
    public double getSaldo() {
        return saldo;
    }

    // methoden
    public void stort(double stort) {
        if (controle()) {
            saldo += stort;
        }
        print();
    }
    public void neemOp(double opname) {
        if (controle()){
            if (saldo == 0) {
                System.out.println("u kan geen geld opnemen");
            } else if (saldo < opname) {
                System.out.println("u mag enkel" + saldo + "euro opnemen");
                saldo = 0;
            } else {
                saldo -= opname;
            }
        }
        print();
    }
    public void doeVerrichting(double [] bedrag) {
        for (int i = 0; i < bedrag.length; i++) {
            if (bedrag[i] > 0) {
                stort(bedrag[i]);
            } else {
                neemOp(-bedrag[i]);
            }
        }
    }
    private boolean controle() { // controleert of er een rekeningnummer en een naam is
        boolean oke = true;
        if (rekeningnummer.equals("geen")) {
            System.out.println("sorry, geen rekeningnummer");
            oke = false;
        } else if (naam.equals("onbekend")) {
            System.out.println("geef de naam van de eigenaar in");
            this.naam = input.nextLine();
        }
        return oke;
    }
    public void schrijfRenteBij() {
        saldo += saldo * rentepercentage;
        print();
    }
    public void print() {
        System.out.println("saldo op spaarrekening " + rekeningnummer + " op naam van " + naam + " bedraagt " + saldo + " euro");
    }
}
