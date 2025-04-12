import java.util.*;

public class ZeroSumSubarrays {
    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;
        List<int[]> result = new ArrayList<>();
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumMap.containsKey(sum)) {
                List<Integer> indices = sumMap.get(sum);
                for (int start : indices) {
                    result.add(new int[]{start + 1, i});
                }
            }

            sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

    
        if (result.isEmpty()) {
            System.out.println("No zero-sum subarrays found.");
        } else {
            System.out.println("Zero-sum subarrays:");
            for (int[] pair : result) {
                System.out.print("[");
                for (int k = pair[0]; k <= pair[1]; k++) {
                    System.out.print(arr[k]);
                    if (k != pair[1]) System.out.print(", ");
                }
                System.out.println("]");
            }
        }
    }

   
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};
        findZeroSumSubarrays(arr);
    }
}
