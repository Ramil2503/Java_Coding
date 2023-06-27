package HW1;

import java.util.Scanner;

public class AdditionalTask {
    /*
     * Some numbers can be replaced with a question mark,
     * for example 2? + ?5 = 69.
     * It is required to restore the expression to the correct equality.
     * Suggest at least one solution or report that there is none.
     */
    public static void main(String[] args) {
        solveEquation();
    }

    public static void solveEquation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        String firstNumberInput = scanner.nextLine();

        System.out.print("Enter the second number: ");
        String secondNumberInput = scanner.nextLine();

        System.out.print("Enter the right side of the equation: ");
        int rightSide = scanner.nextInt();

        for (int questionMark1 = 0; questionMark1 <= 9; questionMark1++) {
            for (int questionMark2 = 0; questionMark2 <= 9; questionMark2++) {
                String firstNumber = replaceQuestionMark(firstNumberInput, questionMark1);
                String secondNumber = replaceQuestionMark(secondNumberInput, questionMark2);

                if (Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber) == rightSide) {
                    System.out.println("Solution found:");
                    System.out.println(firstNumber + " + " + secondNumber + " = " + rightSide);
                    scanner.close();
                    return;
                }
            }
        }

        System.out.println("No solution found.");
        scanner.close();
    }

    public static String replaceQuestionMark(String number, int questionMarkValue) {
        String replacedNumber = number.replaceFirst("\\?", Integer.toString(questionMarkValue));
        return replacedNumber;
    }
}
