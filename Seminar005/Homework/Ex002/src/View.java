import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class View {
    private static Scanner sc = new Scanner(System.in);
    private static Path path;
    public static int returnAnswer() throws SlightException {
        System.out.println("Для выхода нажмите 0, для сохранения и выхода 11: ");
        System.out.println("Введите число от 1 до 9: ");

        if (sc.hasNextInt()){
            int answer = sc.nextInt();
            if ((answer>-1 && answer<10) || answer == 11){
                return answer;
            }else {
                throw new SlightException("Число неверно, повторите ввод.");
            }
        }else {
            throw new RuntimeException("Вы ввели не число.");
        }
    }

    public static void saveGame(String result) throws IOException {
        Path file = Files.createFile(Paths.get("src/Save.txt"));
        if (Files.exists(file)) {
            Files.write(file, Collections.singleton(result), UTF_8);
        }
    }

    public static boolean isExist(){
        return Files.exists(Paths.get("src/Save.txt"));
    }

    public static byte[] loadGame() throws IOException {

        Path file = Paths.get("src/Save.txt");
        List<String> lines = new LinkedList<>();
        if (Files.exists(file)) {
            lines = Files.readAllLines(file, UTF_8);
        }

        byte[] newField = lines.get(0).getBytes();
        byte[] newArray = new byte[9];
        System.arraycopy(newField, 0, newArray, 0, newField.length);
        for (int i = 0; i < 9; i++) {
            if (newArray[i] !=0){
                newArray[i] = (byte) (newArray[i] - 48);
                if (newArray[i]==1){
                    newArray[i]=2;
                } else if (newArray[i]==2) {
                    newArray[i]=1;
                }
                System.out.println(newArray[i]);
            }
        }
        Files.delete(file);
        return newArray;
    }

    public static void scannerClose(){
        sc.close();
    }
}
