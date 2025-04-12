import java.io.*;
import java.nio.charset.StandardCharsets;

public class Binarydata{
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        String filePath = "example.txt";

        try {
            try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
                bufferedReader.close();
                inputStreamReader.close();
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
