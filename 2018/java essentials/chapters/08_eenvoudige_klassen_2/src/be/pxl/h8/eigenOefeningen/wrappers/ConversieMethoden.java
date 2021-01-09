package be.pxl.h8.eigenOefeningen.wrappers;

public class ConversieMethoden {
    public static void main(String[] args) {
        //Integer intObjA = "5"; // dit werkt niet
        Integer intObjValueString = Integer.valueOf("5"); // 5.1 werkt niet
        Integer intObjValueInt = Integer.valueOf(5);
        Integer intObjParseString = Integer.parseInt("1"); // 1.1 werkt niet
        //Integer intObjParseInt = Integer.parseInt(1) // verwacht string

        intObjValueString.longValue();

        // omzetten
        int i = Integer.parseInt("5");
        Long l = Long.parseLong("5");
        float f = Float.parseFloat("2.2");
        double d = Double.parseDouble("5.5");

        Integer.toString(1);
        Long.toString(1);
        Float.toString(1);
        Double.toString(1);
    }
}
