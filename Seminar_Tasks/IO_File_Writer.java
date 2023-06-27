package Seminar_Tasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class IO_File_Writer {
    /*
    Write a method that makes up a 100-word repeating compound 
    TEST and the method that wrote this article to a plain text file, 
    process exceptions.
     */
    static Logger logger;

    public static void main(String[] args) {
        int n = 100;
        String s = "Boom";
        String s1 = duplicate(s, n);
        String filePath = "src/test.txt";

        createLogger();

        writeToFile(s1, filePath);
        System.out.println(readInFile(filePath));

        closeLogger();
    }

    private static void closeLogger() {
        for (Handler handler : logger.getHandlers()) {
            handler.close();
        }
    }

    private static void createLogger() {
        logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("src/log.txt", true);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleFormatter formatter = new SimpleFormatter();
        if (fileHandler != null) {
            fileHandler.setFormatter(formatter);
        }
    }

    static String readInFile(String filePath) {
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    static void writeToFile(String s1, String filePath) {

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(s1);
            writer.write("\n");
            writer.flush();
            logger.info("Successfully saved!");
        } catch (Exception e) {
            e.printStackTrace();
            logger.warning("Was not able to save file!");
        }
    }

    static String duplicate(String s, int n) {
        return s.repeat(n);
    }
}
