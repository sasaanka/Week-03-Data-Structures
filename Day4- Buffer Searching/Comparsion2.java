import java.io.*;
public class Comparsion2 {
    public static void main(String[] args) {
        String word = "hello";
        long startBuilder = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            builder.append(word);
        }
        long endBuilder = System.nanoTime();
        System.out.println("StringBuilder time: " + (endBuilder - startBuilder) / 1_000_000 + " ms");
        long startBuffer = System.nanoTime();
        @SuppressWarnings("ConvertToTryWithResources")
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 1_000_000; i++) {
            buffer.append(word);
        }
        long endBuffer = System.nanoTime();
        System.out.println("StringBuffer time: " + (endBuffer - startBuffer) / 1_000_000 + " ms");
        try (BufferedReader reader = new BufferedReader(new FileReader("largefile.txt"))) {
            long startRead = System.nanoTime();
            int wordCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    wordCount += line.trim().split("\\s+").length;
                }
            }

            long endRead = System.nanoTime();
            System.out.println("FileReader word count: " + wordCount);
            System.out.println("FileReader time: " + (endRead - startRead) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("largefile.txt"), "UTF-8"))) {

            long startRead = System.nanoTime();
            int wordCount = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    wordCount += line.trim().split("\\s+").length;
                }
            }

            long endRead = System.nanoTime();
            System.out.println("InputStreamReader word count: " + wordCount);
            System.out.println("InputStreamReader time: " + (endRead - startRead) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
    }
}
