import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\mnidchenko\\Files\\Java\\StreamsAndFiles\\resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\output.txt";


        try (BufferedReader reader = new BufferedReader (new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath));
        ) {
            reader.lines().forEach(line -> writer.write(line.toUpperCase()+ "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
