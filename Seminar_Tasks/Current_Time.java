package Seminar_Tasks;
import java.time.LocalTime;
import java.util.Scanner;

public class current_Time {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime time = LocalTime.now();
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        int hour = time.getHour();
        if (hour >= 5 && hour < 12) {
            System.out.println("Good morning, " + name + "!");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Good day, " + name + "!");
        } else if (hour >= 18 && hour < 23) {
            System.out.println("Good evening, " + name + "!");
        }
        scanner.close();
    }
}
