package HW5.Task1;

import java.util.HashMap;
import java.util.Map;

public class Contacts {
    Map<String, String> contacts = new HashMap<>();

    void addNote(String num, String name){
        contacts.put(num, name);
    }

    String findByName(String lastName){
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry: contacts.entrySet()){
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

