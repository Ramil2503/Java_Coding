package HW1;
import java.util.Scanner;

public class Task1_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        int triangularNumber = calculateTriangularNumber(n);
        System.out.println("The " + n + "-th triangular number is: " + triangularNumber);
        scanner.close();
    }

    public static int calculateTriangularNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
