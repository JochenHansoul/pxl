package be.pxl.h6.voorbeeldPersoon;

public class Student extends Persoon {
    // opdracht 3.1
    private int leerkrediet;
    private String studentennummer;
    private String opleiding;
    private static int aantal = 0; // opdracht 7.3

    // opdracht 6.1 constructors
    public Student() {
        this("onbekend", "onbekend");
    }
    public Student(String naam, String voornaam) {
        this(naam, voornaam, "15999999", "XXX");
    }
    public Student(String naam, String voornaam, String studentennummer, String opleiding) {
        super(naam, voornaam);
        this.studentennummer = studentennummer;
        this.opleiding = opleiding;
        this.leerkrediet = 140;
        aantal++;
    }
    public Student(Student student) { // opdracht 6.2 copyconstructor
        this(student.getNaam(), student.getVoornaam(), student.studentennummer, student.opleiding);
        leerkrediet = student.leerkrediet;
    }

    // opdr 3.2 setters
    public void setLeerkrediet(int leerkrediet) {
        this.leerkrediet = leerkrediet;
    }
    public void setStudentennummer(String studentennummer) {
        this.studentennummer = studentennummer;
    }
    public void setOpleiding(String opleiding) {
        this.opleiding = opleiding;
    }

    // getters
    public int getLeerkrediet() {
        return leerkrediet;
    }
    public String getOpleiding() {
        return opleiding;
    }
    public static int getAantal() {
        return aantal;
    }

    // methoden
    public void weizigLeerkrediet(int aantal) {
        setLeerkrediet(leerkrediet + aantal);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("studentennummer " + studentennummer);
        System.out.println("opleiding " + opleiding);
        System.out.println("leerkrediet " + leerkrediet);
    }
}
