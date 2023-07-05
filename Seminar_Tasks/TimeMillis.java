package Seminar_Tasks;

import java.util.ArrayList;
import java.util.LinkedList;

public class TimeMillis {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        long timeStartArray = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list1.add(0, i);
        }
        long timeFinishArray = System.currentTimeMillis();
        System.out.println(timeFinishArray - timeStartArray);

        long timeStartLinked = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list2.add(0, i);
        }
        long timeFinishLinked = System.currentTimeMillis();
        System.out.println(timeFinishLinked - timeStartLinked);
    }
}
