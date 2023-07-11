package HW5.Task2;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        String employeeData = "John Smith, Jane Johnson, Michael Williams, Emily Davis, Emily Brown, " +
                "John Miller, David Wilson, Peter Clark, Peter Peterson, Mary Taylor, " +
                "Sarah White, Mary Scott, Mary Robinson, Sarah Hill, " +
                "Anna Adams, John Mitchell, Peter King";

        List<String> employees = Arrays.asList(employeeData.split(", "));

        Map<String, Integer> nameCountMap = new TreeMap<>();

        for (String employee : employees) {
            String name = employee.split(" ")[0];

            nameCountMap.put(name, nameCountMap.getOrDefault(name, 0) + 1);
        }

        Map<Integer, List<String>> resultMap = new TreeMap<>(Collections.reverseOrder());
        
        for (Map.Entry<String, Integer> entry : nameCountMap.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            if (count > 1) {
                List<String> namesList = resultMap.get(count);
                if (namesList == null) {
                    namesList = new ArrayList<>();
                    resultMap.put(count, namesList);
                }
                namesList.add(name);
            }
        }

        for (Map.Entry<Integer, List<String>> entry : resultMap.entrySet()) {
            int count = entry.getKey();
            List<String> names = entry.getValue();
            for (String name : names) {
                System.out.println(name + ": " + count);
            }
        }
    }
}
