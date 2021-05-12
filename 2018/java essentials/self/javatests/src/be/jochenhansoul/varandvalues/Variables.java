package be.jochenhansoul.varandvalues;

public class Variables {
    public static void main(String[] arg) {
        System.out.println("s".length());
        String s;
        //System.out.println(s.length()); // error: variable s might not have been initialized
        s = null;
        System.out.println(s.length()); // compiles but NullPointerException
    }
}
