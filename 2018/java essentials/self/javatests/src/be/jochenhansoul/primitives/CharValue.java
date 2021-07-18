package be.jochenhansoul.primitives;

public class CharValue {
    public static void main(String[] args) {
        char c1 = 'A';
        char c2 = 33;
        int i1 = c1;
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(i1);

        System.out.println("string c1: " + c1);
        System.out.println("string i1: " + i1);

        //char c3 = -1; //error: incompatible types: possible lossy conversion from int to char
        char c4 = 64647;
        System.out.println("string c4: " + c4);

        /*
        WAARDES
        1) primitieve waardes bestaan altijd en zijn altijd -1, 0, 1, 1 of A, B, C..., true/false (en float en double).
        2) Een string waarde kan leeg zijn, letterlijk een lege string "".
        3) integers en characters zijn in principe hetzelfde maar ze casten natuurlijk anders naar  een string en
        een integer kan kleiner zijn dan 0 en groter dan een of ander getal.
        */
    }
}
