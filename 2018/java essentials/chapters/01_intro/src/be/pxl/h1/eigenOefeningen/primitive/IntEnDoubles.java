package be.pxl.h1.eigenOefeningen.primitive;

public class IntEnDoubles {
    public static void main(String[] args) {
        // int and long
        int i = 2147483647;
        long l = 2147483648L;
        System.out.println("i = " + i);
        System.out.println("l = " + l);
        int i1 = (int) l - 1000000;
        System.out.println("i1 = " + i1);
        int i2 = (int) l;
        System.out.println("i2 = " + i2);


        System.out.println("\nlong fits in int:");
        long l2 = 100L;
        int i3 = (int) l2;
        System.out.println(i3);

        // double
        double d = 1;
        System.out.println("double d = " + d);
    }
}
