package HW4.Task1;

public class LinkedList {
    LinkedListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void addNode(int value) {
        LinkedListNode newNode = new LinkedListNode(value);
        if (head == null) {
            head = newNode;
        } else {
            LinkedListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void reverseLinkedList() {
        LinkedListNode previous = null;
        LinkedListNode current = head;
        LinkedListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }
}
