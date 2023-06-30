package Lesson005;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Ex001 {
    public static void main(String[] args) {
        Random random = new Random();
        int max = random.nextInt(100 + 1);
        List<String> lines = new LinkedList<>();

        for (int i = 0; i < max; i++) {
            lines.add(i, randomString());
        }
        
        Path file = null;
        try{
            if(Files.exists(Paths.get("Lesson005/cat.txt"))){
                Files.delete(Paths.get("Lesson005/cat.txt"));
            }
            file = Files.createFile(Paths.get("Lesson005/cat.txt"));
        
            if (Files.exists(file)) {
                Files.write(file, lines, StandardCharsets.UTF_8);
                lines = Files.readAllLines(file, StandardCharsets.UTF_8);
                for (String s : lines) {
                    System.out.println(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static char randomChar() {
        Random random = new Random();
        return (char)(random.nextInt(26) + 'A');
    }

    private static String randomString() {
        Random random = new Random();
        String generatedString = "";
        for (int i = 0; i < random.nextInt(100 + 1); i++) {
            generatedString += randomChar();
        }
        return generatedString;
    }
}
