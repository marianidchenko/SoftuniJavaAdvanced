import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\mnidchenko\\Files\\Java\\StreamsAndFiles\\resources";
        String inputOnePath = basePath + "\\inputOne.txt";
        String inputTwoPath = basePath + "\\inputTwo.txt";
        String outputPath = basePath + "\\results.txt";

        try (BufferedReader readerOne = new BufferedReader(new FileReader(inputOnePath));
             BufferedReader readerTwo = new BufferedReader(new FileReader(inputTwoPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath));
        ) {
            readerOne.lines().forEach(line -> writer.write(line + "\n"));
            readerTwo.lines().forEach(line -> writer.write(line + "\n"));
        } catch (IOException e) {}
    }
}
