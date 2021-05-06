package be.pxl.h8.oefeningen.oef02;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.Scanner;

public class Oefening2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // input aantal getallen, minimumwaarde en maximumwaarde
        String inputMessage = "Geef het aantal getallen, de minimumwaarde en de maximumwaarde in";
        System.out.println(inputMessage);
        String[] values = input.nextLine().split(" ");
        while (values.length != 3) {
            System.out.println(inputMessage);
            values = input.nextLine().split(" ");
        }
        int amount = Integer.parseInt(values[0]);
        int min = Integer.parseInt(values[1]);
        int max = Integer.parseInt(values[2]);

        // controle minimumwaarde en maximumwaarde
        System.out.println("aantal getallen " + amount);
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
            System.out.println("kleinste getal (na wisseling) " + min);
            System.out.println("grootste getal (na wisseling) " + max);
        }

        ArrayList<Integer> numbers = generateRandomNumberList(amount, min, max, new Random());
        OptionalDouble optionalDouble = numbers.stream()
            .mapToDouble(i -> i)
            .average();
        if (optionalDouble.isPresent()) {
            System.out.println("het gemiddelde is: " + optionalDouble.getAsDouble());
        } else {
            System.out.println("het gemiddelde is unknown");
        }
        input.close();
    }

    public static ArrayList<Integer> generateRandomNumberList(int amount, int min, int max, Random random) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int difference = max - min;
        for (int i = 0; i < amount; i++) {
            int n = random.nextInt(difference) + min;
            numbers.add(n);
            System.out.println(n);
        }
        return numbers;
    }
}
