package be.pxl.h6.voorbeeldPersoon;

public class SchoolApp {
    public static void main(String[] args) {
        Persoon persoon = new Persoon();
        Student student = new Student();
        student.setVoornaam("Ernest");
        student.setNaam("Verrijcken");
        student.setLeerkrediet(120);
        student.setOpleiding("toegepaste informatice");
        System.out.println("student " + student.getVoornaam() + " " + student.getNaam());
        System.out.println("studentennummer " + student.getLeerkrediet());
        System.out.println("opleiding " + student.getOpleiding());
        student.weizigLeerkrediet(-20);
        System.out.println("beschikbaar leerkrediet " + student.getLeerkrediet());
        System.out.println();
        // opdracht 4.1
        persoon.print();
        student.print();
        System.out.println();
        // opdracht 5A
        Persoon polymorf = new Student(); // polymorfisme, dit is altijd een persoon en heeft ook eigenschappen van Student
        ((Student) polymorf).setOpleiding("tin"); // veranderd het tijdelijk
        System.out.println("polymorf object:");
        polymorf.print();
        System.out.println();
        //deze bewerking: polymorf = new Persoon(); zet het om naar een persoon en is geen student meer, kan niet omkeren
        // opdracht 5B
        Lector lector = new Lector();
        lector.setNaam("Wally");
        lector.setVoornaam("Marina");
        lector.setPersoneelsnummer("007");
        lector.setAanstellingspercentage(10);
        lector.setSalaris(200);
        lector.print();
        System.out.println(); // lijn tussen
        lector.setAanstellingspercentage(190);
        lector.print();
        Lector lector1 = new Lector();
        Lector lector2 = new Lector("Hilven", "Brecht", 15.5, 5);
        Student student1 = new Student();
        Student student2 = new Student("Huysentruit", "Piet");
        // extra opdracht
        Persoon lectorPolymorf = new Lector(); // object lector maar is eigenlijk een persoon.
        ((Lector) lectorPolymorf).setPersoneelsnummer("4544"); // eerst kasten, daarna het personeelsnr zetten
        System.out.printf("%n%n");
        Persoon[] personen = {persoon, student, polymorf, lector, lectorPolymorf, student1, student2, lector1, lector2}; // dit is de echte reden waarom polymorfisme wordt gedaan.
        System.out.println("Het printen van al de de personen:");
        for (Persoon p: personen) {
            p.print();
            System.out.println();
        }
        // opdracht 7.2
        System.out.println("Aantal aangemaakte personen " + Persoon.getAantal());
        System.out.println("Aantal aangemaakte studenten " + Student.getAantal());
    }
}
