public class Bubble{
    public static void main(String[] args) {
        int[] nums={1,5,8,3,6};
        int len=nums.length;
        int temp;
        System.out.print("Before sorting: ");
        for (int num : nums){
            System.out.print(num+" ");
        }
        //
        for(int i=0;i<len;i++){
            for(int j=0;j<len-i-1;j++){
                if(nums[j]>nums[j+1]){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        System.out.println();
        System.out.print("After sorting: ");
        for(int num: nums){
            System.out.print(num+" ");
        }
    }
}