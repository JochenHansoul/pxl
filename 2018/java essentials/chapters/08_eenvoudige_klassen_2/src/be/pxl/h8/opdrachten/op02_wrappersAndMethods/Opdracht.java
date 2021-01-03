package be.pxl.h8.opdrachten.op02_wrappersAndMethods;

public class Opdracht {
    public static void main(String args[]) {

        System.out.println("min.value = " + Integer.MIN_VALUE);
        System.out.println("max.value = " + Integer.MAX_VALUE);
        // geeft de maximale waarde 2 mil en minimale waarde - 2 mil

        Integer iObj = new Integer("1234567"), // moet echt new Integer () bij staan!
                jObj = new Integer(1234567);
        // blijkbaar wordt "1234567" automatich

        System.out.println("waarden van de integer objecten vergeleken : "
                + iObj.equals(jObj));
        //

        System.out.println("referenties vergeleken : "
                + (iObj == jObj));
        //

        System.out.println("int-waarden vergeleken met constante: "
                + (iObj.intValue() == 1234567));
        // dankzij intValue() wordt de waarde opgevraagd

        System.out.println("int-waarden vd objecten vergeleken : "
                + (iObj.intValue() == jObj.intValue()));
        //

        int k = -45;
        Integer kObj = new Integer(k);
        System.out.println(k);
        System.out.println(kObj.toString());
        //
        System.out.println(Integer.toString(k));
        //
        System.out.println("de to string met een getal: " + Integer.toString(k, 2)); // lijken op elkaar maar zijn niet hetzelfde, verschillend bij negatieve getallen!
        //
        System.out.println(Integer.toBinaryString(k)); // voor negatieve waarde toBinair en toHexString tonen alles 1/f en 0 voor hetgeen wat is
        //
        System.out.println(Integer.toHexString(k));
        //
        System.out.println(Integer.toString(k, 16)); // -16 -16 - 13 = -2d in hexadecimal
    }

}
