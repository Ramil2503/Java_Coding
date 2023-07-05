package HW3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> numbers = getNumbersFromUser();

        List<Integer> oddNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }

        System.out.println("Initial array: " + numbers);
        System.out.println("Array without even numbers: " + oddNumbers);
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
