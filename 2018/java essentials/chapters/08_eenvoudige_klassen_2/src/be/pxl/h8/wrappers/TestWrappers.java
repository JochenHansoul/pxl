package be.pxl.h8.wrappers;

public class TestWrappers {
    public static void main(String[] args) {
        Integer intObject1 = new  Integer(5);
        Integer intObject2 = new Integer(5);
        int i = intObject1.intValue();

        System.out.println(intObject1);
        System.out.println("i = " + i);
        System.out.println(intObject1 == intObject2);
        System.out.println(intObject1.equals(intObject2));

        // wrapper objecten zijn immutable
        Integer object1 = 1; // autoboxing gebeurt automatisch
        object1++;
        System.out.println(object1);
        methode(5);
        System.out.println("int max: " + Integer.MAX_VALUE);
        System.out.println("int min: " + Integer.MIN_VALUE);
        System.out.println("double NAN: " + Double.NEGATIVE_INFINITY);
        System.out.println("waarde is 0/0: " + Double.isNaN(0));
        System.out.println("oneindig: " + Double.isInfinite(2.0 / 0));
        Integer mogelijkInt = new Integer("123"); // moet echt new Integer en tussen haakjes staan!
        System.out.println("is dit een int? " + mogelijkInt);
    }

    public static void methode(long i) {
        System.out.println("long");
    }

    public static void methode(int i){
        System.out.println("int");
    }
}