package be.pxl.h1.eigenOefeningen;

public class TestOpArgs {
    public static void main(String[] args) {
        System.out.println(args.length);
        for (int i = 0; i < args.length; i++) {
            args[i] = "1";
        }
        for (String s: args) {
            System.out.println(s);
        }
    }
}
