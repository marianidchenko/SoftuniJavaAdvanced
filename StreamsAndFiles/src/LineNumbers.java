import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\mnidchenko\\Files\\Java\\StreamsAndFiles\\resources";
        String inputPath = basePath + "\\inputLineNumbers.txt";
        String outputPath = basePath + "\\output.txt";


        try (BufferedReader reader = new BufferedReader (new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath));
        ) {
            String line = reader.readLine();
            int rowCounter = 1;
            while (line != null) {
                writer.write(String.format("%d. %s\n", rowCounter++, line));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
