public class Comparsion {
    public static void main(String[] args) {
        int n = 1_000_000;
        String text = "hello";
        StringBuilder builder = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < n; i++) {
            builder.append(text);
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;
        
        @SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer buffer = new StringBuffer();
        long startBuffer = System.nanoTime();
        for (int i = 0; i < n; i++) {
            buffer.append(text);
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;
        System.out.println("Time taken by StringBuilder: " + timeBuilder / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuffer: " + timeBuffer / 1_000_000 + " ms");
    }
}
