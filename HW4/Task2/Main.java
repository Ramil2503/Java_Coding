package HW4.Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();

        System.out.print("Enter the number of elements: ");
        int numElements = scanner.nextInt();

        System.out.println("Enter the elements: ");
        for (int i = 0; i < numElements; i++) {
            int value = scanner.nextInt();
            queue.enqueue(value);
        }

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. First");
            System.out.println("4. Print Queue");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int enqueueValue = scanner.nextInt();
                    queue.enqueue(enqueueValue);
                    System.out.println("Element enqueued successfully!");
                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        int dequeuedValue = queue.dequeue();
                        System.out.println("Dequeued element: " + dequeuedValue);
                    }
                    break;
                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        int firstValue = queue.first();
                        System.out.println("First element: " + firstValue);
                    }
                    break;
                case 4:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Elements in the queue:");
                        for (int value : queue) {
                            System.out.print(value + " ");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
