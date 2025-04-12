public class PeakElement{
    public static int peak(int[] nums){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        } 
        return left;
    }
    public static void main(String[] args) {
        int[] nums={2,4,8,5,9,14,20};
        int result=peak(nums);
        System.out.println("The peak element is at : "+result);
        System.out.println("The element is: "+nums[result]);
    }
}