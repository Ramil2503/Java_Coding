package Seminar_Project1;

import java.util.HashMap;
import java.util.Map;

public class Passports {
    Map<String, String> passports = new HashMap<>();

    void addNote(String num, String name){
        passports.put(num, name);
    }

    String findByName(String lastName){
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry: passports.entrySet()){
            String num = entry.getKey();
            String name = entry.getValue();
            if (name.equalsIgnoreCase(lastName)){
                stringBuilder.append(num);
                stringBuilder.append(": ");
                stringBuilder.append(name);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}

