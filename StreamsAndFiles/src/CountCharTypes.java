import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CountCharTypes {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\mnidchenko\\Files\\Java\\StreamsAndFiles\\resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\output.txt";
        List<String> vowelsList = Arrays.asList("a", "e", "i", "o", "u");
        List<String> punctuationList = Arrays.asList("!", ",", ".", "?");
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        try (BufferedReader reader = new BufferedReader (new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath));
        ) {
            String line = reader.readLine();
            while (line != null) {
                String[] tokens = line.replaceAll("\\s+", "").split("");
                for (String token : tokens) {
                    if (vowelsList.contains(token)) {
                        vowels++;
                    } else if (punctuationList.contains(token)) {
                        punctuation++;
                    } else {
                        consonants++;
                    }
                }
                line = reader.readLine();
            }
            writer.write(String.format("Vowels: %d\n", vowels));
            writer.write(String.format("Consonants: %d\n", consonants));
            writer.write(String.format("Punctuation: %d", punctuation));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
