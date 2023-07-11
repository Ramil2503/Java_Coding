package HW4.Task3;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.print("Enter the number of elements: ");
        int numElements = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < numElements; i++) {
            int element = scanner.nextInt();
            linkedList.add(element);
        }

        int sum = 0;
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            sum += element;
        }

        System.out.println("Sum of all elements: " + sum);
        System.out.println("LinkedList elements: " + linkedList);

        scanner.close();
    }    
}
