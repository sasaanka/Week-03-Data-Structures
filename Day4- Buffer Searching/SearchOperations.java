import java.util.Arrays;
public class SearchOperations {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int missing = firstMissingPositive(Arrays.copyOf(nums, nums.length)); 
        int index = binarySearch(sortedNums, target);
        System.out.println("First missing positive integer: " + missing);
        if (index != -1) {
            System.out.println("Target " + target + " found at index (in sorted array): " + index);
        } else {
            System.out.println("Target " + target + " not found.");
        }
    }
}
