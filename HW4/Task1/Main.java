package HW4.Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.print("Enter the number of elements in the linked list: ");
        int numElements = scanner.nextInt();

        System.out.println("Enter the elements (separate by enter):");
        for (int i = 0; i < numElements; i++) {
            int value = scanner.nextInt();
            list.addNode(value);
        }

        System.out.println("Original LinkedList:");
        list.display();

        System.out.println("Reversed LinkedList:");
        list.reverseLinkedList();
        list.display();

        scanner.close();
    }
}
