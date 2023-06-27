package HW1;

import java.util.Scanner;

public class Task1_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        long factorial = calculateFactorial(n);
        System.out.println("The factorial of " + n + " is: " + factorial);
        scanner.close();
    }

    public static long calculateFactorial(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
