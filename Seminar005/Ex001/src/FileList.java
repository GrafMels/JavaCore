import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileList {
    LinkedList<MyFile> fileList = new LinkedList<>();
    int count = 0;
    Path directory = Paths.get("files");
    StringBuilder fileNames;
    Encryptor encryptor;
    public FileList() {
        fileNames = new StringBuilder(directory.getFileName().toString());
        fileNames.append("/");
        fileNames.append("File");
        fileNames.append(".txt");

        try {
            // используя метод `Files.walk()` с try-with-resources
            try (Stream<Path> paths = Files.walk(directory))
            {
                List<Path> tempList = paths.filter(Files::isRegularFile).toList();
                for (Path path : tempList) {
                    MyFile newFile = new MyFile(path);
                    fileList.add(newFile);
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addFile() throws FileNotFoundException {
        count++;
        MyFile newFile = new MyFile(fileNames.replace(10, 10, Integer.toString(count)).toString());
        fileNames.replace(10, 11, "");
        fileList.add(newFile);
    }

    public String readAllFile(int index) throws IOException {
        List<String> newList = Files.readAllLines(fileList.get(index).getPath(), StandardCharsets.UTF_8);
        StringBuilder fullString = new StringBuilder();
        for (String s : newList) {
            fullString.append(s);
            fullString.append("\n");
        }
        return fullString.toString();
    }

    public void writeAllFile(int i, StringBuilder sb) throws IOException {
        Files.write(fileList.get(i).getPath(), Collections.singleton(sb.toString()), StandardCharsets.UTF_8);
    }

    public void newEncryptor(int key){
        encryptor = new Encryptor(key);
    }

    public void encryptFile(int numberFile, int snumberFile, int key) throws IOException {
        StringBuilder newList = new StringBuilder(readAllFile(numberFile));
        newEncryptor(123);
        writeAllFile(snumberFile, encryptor.encrypt(newList));
    }

    public void decipherFile(int numberFile) throws IOException {
        StringBuilder newList = new StringBuilder(readAllFile(numberFile));
        writeAllFile(numberFile, encryptor.decipher(newList));
    }

    private static class Encryptor {
        int key;
        private Encryptor(int key){
            this.key = key;
        }

        private StringBuilder encrypt(StringBuilder noEncryptText){
            char[] temp = noEncryptText.toString().toCharArray();
            noEncryptText.delete(0, noEncryptText.length());
            for (int i = 0; i < temp.length; i++) {
                temp[i] = (char)((int)temp[i]-key);
                noEncryptText.append(temp[i]);
            }
            return noEncryptText;
        }

        private StringBuilder decipher(StringBuilder noEncryptText){
            char[] temp = noEncryptText.toString().toCharArray();
            noEncryptText.delete(0, noEncryptText.length());
            for (int i = 0; i < temp.length; i++) {
                temp[i] = (char)((int)temp[i]+key);
                noEncryptText.append(temp[i]);
            }
            return noEncryptText;
        }


    }
    private static class MyFile {
        Path path = null;
        private MyFile(String pathName) throws FileNotFoundException {
            try {
                Path newPath = Paths.get(pathName);
                if (!Files.exists(newPath)){
                    path = Files.createFile(newPath);
                }else{
                    path = newPath;
                }
            } catch (IOException e) {
                throw new FileNotFoundException(String.format("File name: %s, doesn't exist", pathName));
            }
        }

        private MyFile(Path path) throws FileNotFoundException {
            this.path = path;
        }

        private Path getPath(){
            return path;
        }
    }
}
