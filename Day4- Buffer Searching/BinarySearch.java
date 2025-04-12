public class BinarySearch{
    public static int binary(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums={2,4,5,8,9};
        int target=9;
        int result=binary(nums, target);
        if(result!=-1){
            System.out.println("Element found at index: "+result);
        }else{
            System.out.println("Not found");
        }
    }
}