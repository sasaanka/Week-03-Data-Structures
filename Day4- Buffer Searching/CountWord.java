import java.io.*;

public class CountWord {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        String filePath = "example.txt";
        String targetWord = "She"; 
        int count = 0;

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");

                for (String word : words) {
                    if (word.replaceAll("[^a-zA-Z]", "").equals(targetWord.toLowerCase())) {
                        count++;
                    }
                }
            }

            bufferedReader.close();
            fileReader.close();

            System.out.println("The word \"" + targetWord + "\" appears " + count + " times.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
