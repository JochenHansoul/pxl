package be.pxl.h8.oefeningen.oef02_optionaldouble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
            System.out.println("kleinste getal (na wisseling) " + min);
            System.out.println("grootste getal (na wisseling) " + max);
        }

        // generating list of random numbers and optional average
        List<Integer> numbers = generateRandomNumberList(amount, min, max, new Random());
        OptionalDouble optionalAverage = numbers.stream()
            .mapToDouble(i -> i)
            .average();

        // printing the list of numbers and average
        System.out.println(Arrays.toString(numbers.toArray()));
        System.out.printf("het gemiddelde is: %s%n",
            (optionalAverage.isPresent()) ? optionalAverage.getAsDouble() + "" : "unknown");

        input.close();
    }

    public static ArrayList<Integer> generateRandomNumberList(int amount, int min, int max, Random random) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int difference = max - min;
        for (int i = 0; i < amount; i++) {
            numbers.add(random.nextInt(difference) + min);
        }
        return numbers;
    }
}
