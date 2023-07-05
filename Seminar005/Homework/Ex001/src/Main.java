import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    public static void main(String[] args) {
        try {
            StringBuilder absolutePath = new StringBuilder(".");//Передайте сюда абослютный путь папки которую хотите скопировать, она положит всё в паку backup в той же папке
            Path directory = Files.createDirectories(Paths.get(absolutePath.toString()));
            try(Stream<Path> paths = Files.walk(directory)){
                List<Path> tempList = paths.filter(Files::isExecutable).toList();
                for (int i = 0; i < tempList.size(); i++) {
                    System.out.println(tempList.get(i).normalize().toAbsolutePath());
                }
                System.out.println();
                copyAllFiles(tempList, directory);
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println(directory.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyAllFiles(List<Path> fileList, Path directory)throws IOException {

        StringBuilder path = new StringBuilder(String.format("%s/backup", directory.normalize().toAbsolutePath()));
        Path tempPath = Paths.get(path.toString());
        Path newFile = Files.createDirectories(tempPath);
        for (int i = 1; i < fileList.size(); i++) {
            path = new StringBuilder(String.format("%s/backup", directory.normalize().toAbsolutePath()));
            int length = directory.normalize().toAbsolutePath().getNameCount();
            int length1 = fileList.get(i).normalize().toAbsolutePath().getNameCount();
            newFile = Files.copy(fileList.get(i), Paths.get(path.append(String.format("/%s", fileList.get(i).normalize().toAbsolutePath().subpath(length, length1))).toString()), REPLACE_EXISTING);
        }
    }


}