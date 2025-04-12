import java.util.Scanner;

public class Countingsort {

    public void countingSort(int[] arr) {
        int max = arr[0];

        // Find the maximum element
        for (int num : arr) {
            if (num > max)
                max = num;
        }

        // Create count array
        int[] count = new int[max + 1];

        // Count the occurrences
        for (int num : arr) {
            count[num]++;
        }

        // Build the sorted array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " non-negative integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        Countingsort sorter = new Countingsort();
        sorter.countingSort(arr);

        System.out.println("\nSorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
