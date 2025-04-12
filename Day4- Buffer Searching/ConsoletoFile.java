import java.io.*;
public class ConsoletoFile {
    public static void main(String[] args) {
        try (
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(isr);
            FileWriter writer = new FileWriter("example.txt", true); 
        ) {
            System.out.println("Enter text (type 'exit' to finish):");
            String line;
            while (true) {
                line = reader.readLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line + System.lineSeparator());
            }
            System.out.println("Input saved to example.txt.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
