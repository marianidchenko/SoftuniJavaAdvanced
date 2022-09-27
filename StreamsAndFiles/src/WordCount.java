import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class WordCount {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\mnidchenko\\Files\\Java\\StreamsAndFiles\\resources";
        String wordPath = basePath + "\\words.txt";
        String inputPath = basePath + "\\text.txt";
        String outputPath = basePath + "\\results.txt";



        try (BufferedReader reader = new BufferedReader (new FileReader(inputPath));
             BufferedReader wordReader = new BufferedReader (new FileReader(wordPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath));
        ) {
            LinkedHashMap<String, Integer> words = new LinkedHashMap<String, Integer>();
            Arrays.stream(wordReader.readLine().split(" ")).toList().forEach(word -> words.put(word, 0));
                String line = reader.readLine();
                while (line != null) {
                    String[] lineAsArray = line.split("\\s+");
                    for (String lineWord : lineAsArray) {
                        if (words.containsKey(lineWord)) {
                            words.put(lineWord, words.get(lineWord) + 1);
                        }
                    }
                    line = reader.readLine();
                }
            words.entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(entry -> writer.write(String.format("%s - %d\n", entry.getKey(), entry.getValue())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
