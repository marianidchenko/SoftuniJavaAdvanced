import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        String basePath = "C:\\Users\\mnidchenko\\Files\\Java\\StreamsAndFiles\\resources\\ExercisesResources";
        Path folder = Paths.get(basePath);
        long size = Files.walk(folder)
                .mapToLong(p -> p.toFile().length())
                .sum();
        System.out.println(String.format("Folder size: %d", size));
    }
}
