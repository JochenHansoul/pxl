package be.jochenhansoul.arithmetic;

public class ZeroDevision {
    public static void main(String[] args) {
        try {
            int i = 1 / 0;
            System.out.println(i);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
