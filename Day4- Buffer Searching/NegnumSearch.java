public class NegnumSearch{
    public static int linearSearch(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums={54,24,-88,57,-1,-58};
        int result=linearSearch(nums);
         if (result != -1) {
            System.out.println("First negative number found at index: " + result);
        } else {
            System.out.println("No negative number found.");
        }
    }
}