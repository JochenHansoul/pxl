package be.pxl.h5.opdracht;

public class BoekApp {
    public static void main(String[] args) {
        Boek boek = new Boek();
        boek.setIsbnnummer("9789026119019");
        boek.setTitel("ik ben niet BOM");
        boek.getAuteur().setNaam("Van de Koelwyck");
        boek.getAuteur().setVoornaam("Marion");
        boek.setBladzijden(128);
        System.out.println("de naam van de auteur " + boek.getAuteur().toString());
        boek.toonBoekGegevens();
    }
}
