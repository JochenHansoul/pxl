package be.jochenhansoul.internalmain;

public class External {
    public static void main(String[] args) {
        System.out.println("external class");
        Internal.main(new String[0]);
    }
}
