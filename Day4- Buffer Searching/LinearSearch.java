public class LinearSearch{
    public static int linearSearch(int[] nums, int target){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums={58,12,56,148,20,125,33,0};
        int target=20;
        int result=linearSearch(nums,target);
        if (result!=-1){
            System.out.println("Element Found at index: "+result);
        }else{
            System.out.println("No elemnt found");
        }
    }
}