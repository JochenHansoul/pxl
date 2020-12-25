package be.pxl.h1.voorbeelden;

import java.util.Scanner;

public class Opdracht8 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Geef je bankrekening in");
        long bankrekeningnummer = input.nextLong();
        // extra geef ook de eigener van de rekening in
        input.nextLine();
        System.out.println("Geef naam en voornaam van de eigenar in");
        String naam = input.nextLine();
        // bereken de laatste 12 cijfers
        long laatsteCijfers =  bankrekeningnummer % 1000000000000L;
        System.out.println("de 12 laatste cijfers zijn " + laatsteCijfers);
        // vermeningvuldig met 1 000 000
        laatsteCijfers = laatsteCijfers * 1000000;
        // vermeerder met 111 400
        laatsteCijfers += 111400;
        // rest na deling door 97
        laatsteCijfers %= 97;
        // verminder met 98
        laatsteCijfers -= 98;
        laatsteCijfers *= -1;
        System.out.println("naam:" + naam + ", Getal na BE in bankrekeningnummer " + laatsteCijfers);
        input.close();
    }
}
