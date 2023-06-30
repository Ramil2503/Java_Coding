package HW2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    static Logger logger;
    public static void main(String[] args) {
        String inputfilePath = "HW2/input.txt";
        String outputfilePath = "HW2/output.txt";

        createLogger();
        String jsonString = readInFile(inputfilePath);
        List<Student> students = parseStudents(jsonString);
        printListOfStudents(students);
        writeToFile(outputListOfStudents(students).toString(), outputfilePath);
        closeLogger();
    }

    static String readInFile(String filePath) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            return new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static List<Student> parseStudents(String jsonString) {
        List<Student> students = new ArrayList<>();
        try {
            jsonString = jsonString.trim().substring(1, jsonString.length() - 1);
            String[] StringStudents = jsonString.split("\\+");
            String surname = null;
            String grade = null;
            String subject = null;

            for (int i = 0 ; i < StringStudents.length; i++) {
                String StringStudent = StringStudents[i].replaceAll("\\},", "}");
                StringStudent = StringStudent.replaceAll("\\}\\\" ", "}");
                StringStudent = StringStudent.replaceAll("\\\"\\{", "{");
                StringStudent = StringStudent.replaceAll("\\{", "").replaceAll("\\}", "");

                String[] properties = StringStudent.split(",");

                for (String property : properties) {
                    String[] keyValue = property.split(":");
                    String key = keyValue[0].replaceAll("\\\\\"", "");
                    String value = keyValue[1].replaceAll("\\\\\"", "");

                    if (key.equals("surname") || key.equals("\r\nsurname")) {
                        surname = value;
                    } if (key.equals("grade")) {
                        grade = value;
                    } if (key.equals("subject")) {
                        subject = value;
                    }
                }
                if (surname != null && grade != null && subject != null) {
                    Student student = new Student();
                    student.setSurname(surname);
                    student.setGrade(grade);
                    student.setSubject(subject);
                    students.add(student);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    static void printListOfStudents(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("Student " + student.getSurname() + " got " + student.getGrade() + " from " + student.getSubject() + ".");
            System.out.println();
        }
    }

    static StringBuilder outputListOfStudents(List<Student> students) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            result = result.append("Student " + student.getSurname() + " got " + student.getGrade() + " from " + student.getSubject() + ".\n");
        }
        return result;
    }
    
    static void writeToFile(String s1, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)){
            writer.write(s1);
            writer.write("\n");
            writer.flush();
            logger.info("The write operation was successful.");
        } catch (Exception e){
            e.printStackTrace();
            logger.warning("Failed to write to the file.");
        }
    }

    private static void createLogger() {
        logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("HW2/log.txt", true);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleFormatter formatter = new SimpleFormatter();
        if (fileHandler != null){
            fileHandler.setFormatter(formatter);
        }
    }

    private static void closeLogger() {
        for (Handler handler: logger.getHandlers()){
            handler.close();
        }
    }
}
