package be.pxl.h3.opdrachten;

import java.util.Random;

public class Opdracht4_randomGetallen {
    public static void main(String[] args) {
        Random random = new Random(1500);

        // a.genereer een willekeurig geheel getal
        int x = random.nextInt();
        System.out.println("het gegenereerde geheel getal is " + x);

        // b. 20 gehele getallen >=0 en <= 10
        int[] array1 =new int[20];
        for (int i = 0; i < 20; i++) {
            array1[i] = random.nextInt(11);
            System.out.println(array1[i]);
        }

        // c. 20 gehele getallen >= 20 en <= 30
        int[] array2 =new int[20];
        for (int i = 0; i < 20; i++) {
            array2[i] = random.nextInt(11) + 20;
            System.out.println(array2[i]);
        }
        System.out.println();

        // d. willekeurige letter
        char letter = (char)(random.nextInt('z' - 'a' + 1) + 'a'); // genereerd een random getal tussen asci waarde 0 tot het einde van het alfabet (met + 1 erbij!).
        System.out.println(letter);// daarna wordt er de waarde van char a begeteld zodat in range alfabet is en dit getal omgezet in een karakter
    }
}