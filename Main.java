import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        String fileName = "src/best.txt";
        int start = 1;
        int end = 15;
        int count = 3;

        // Перевірка існування файлу
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
                return;
            }
        }

        // Запис послідовності випадкових чисел у файл
        try (FileWriter writer = new FileWriter(file)) {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int randomNum = random.nextInt(end - start + 1) + start;
                writer.write(String.valueOf(randomNum));
                writer.write(System.lineSeparator());
            }
            System.out.println("Sequence of random numbers written to a file " + fileName);
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }

        // Читання інформації з файлу і виведення на консоль
        try (FileReader reader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            System.out.println("File contents " + fileName + ":");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}