import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        FileList fl = new FileList();
        try {
            StringBuilder newList = new StringBuilder(fl.readAllFile(0));
            System.out.println(newList.toString());
            fl.encryptFile(0, 1, -123);
//            fl.decipherFile(1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}