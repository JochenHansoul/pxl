package be.pxl.h1.Oefeningen;

import java.util.Scanner;

public class Oef5_prijsHotel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String asterix = "*";
        System.out.println("Geef de hotelcode in, vb. 'AB'");
        String hotelcode = input.next();
        while (!hotelcode.equals("/")) {
            System.out.println("Geef het aantal sterren in, 1 - 5");
            int sterren = input.nextInt();
            input.nextLine();
            System.out.println("Geef de kindercode in 'A' tem 'Z'");
            char kindercode = input.next().charAt(0);
            while (kindercode < 'A'|| kindercode > 'Z') {
                System.out.println("Geef een juiste kindercode in 'A' tem 'Z'");
                kindercode = input.next().charAt(0);
            }
            // berekening prijs per nacht
            double prijsPerNacht = 0;
            if (hotelcode.equals("HI")) {
                prijsPerNacht = 70;
            } else {
                if (sterren >= 4) {
                    prijsPerNacht = 60;
                } else if (sterren == 3) {
                    if (hotelcode.equals("BR") || hotelcode.equals("An")) {
                        prijsPerNacht = 60;
                    }
                    else {
                        prijsPerNacht = 56;
                    }
                } else {
                    prijsPerNacht = 48;
                }
            }
            /*if (hotelcode.equals("HI")) {
                prijsPerNacht = 70;
            }else {
                if (sterren >= 4) {
                    prijsPerNacht = 60;
                }
                else {
                    if (sterren == 3){
                        if (hotelcode.equals("BR") || hotelcode.equals("An")) {
                            prijsPerNacht = 60;
                        }
                        else {
                            prijsPerNacht = 56;
                        }
                    }
                    else {
                        prijsPerNacht = 48;
                    }
                }
            }*/
            // berekening prijs per kind
            double prijsPerKind;
            if (kindercode == 'A' && (sterren == 1 || sterren == 2 || hotelcode.equals("HA"))) {
                prijsPerKind = 0;
            }
            else {
                prijsPerKind = prijsPerNacht * 0.5;
            }
            //output
            System.out.printf(hotelcode + asterix.repeat(sterren) + " %.2f %.2f %.2f %n%n", prijsPerNacht, prijsPerKind, prijsPerNacht + prijsPerKind);
            System.out.println("Geef de hotelcode in:");
            hotelcode = input.next();
        }
        input.close();
    }
}
