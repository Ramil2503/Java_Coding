package HW3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = getNumbersFromUser();

        int min = Collections.min(numbers);

        int max = Collections.max(numbers);

        double mean = 0;
        for (int number : numbers) {
            mean += number;
        }
        mean = mean / numbers.size();

        System.out.println();
        System.out.println("Initial list: " + numbers);
        System.out.println("The minimum is: " + min);
        System.out.println("The maximum is: " + max);
        System.out.println("The arithmetical mean is: " + mean);
    }
    
    private static List<Integer> getNumbersFromUser() {
        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the list: ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter the Number " + (i + 1) + ": ");
            int number = scanner.nextInt();
            numbers.add(number);
        }
        scanner.close();
        return numbers;
    }    
}
