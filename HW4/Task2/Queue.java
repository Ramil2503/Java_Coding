package HW4.Task2;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue implements Iterable<Integer> {
    private LinkedList<Integer> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public void enqueue(int item) {
        queue.addLast(item);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.removeFirst();
    }

    public int first() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return queue.iterator();
    }
}
