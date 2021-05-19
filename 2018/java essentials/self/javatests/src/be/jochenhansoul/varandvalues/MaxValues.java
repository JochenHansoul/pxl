package be.jochenhansoulvarandbalues;

public class MaxValues {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        System.out.println(i + 1);
        //System.out.println(2147483648); //error: integer number too large
        System.out.println(2147483648L);
    }
}
