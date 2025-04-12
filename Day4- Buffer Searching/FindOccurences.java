public class FindOccurences{
    public static int firstOcc(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int result=-1;
        while(left<=right){
            int mid=(left+right)/2;

            if(nums[mid]==target){
                result=mid;
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return result;
    }
    public static int lastOcc(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        int result=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                result=mid;
                left=mid+1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums={1, 2, 3, 3, 3, 4, 5};
        int target=3;
        int first=firstOcc(nums, target);
        int last=lastOcc(nums, target);
        if(first!=-1 && last!=-1){
            System.out.println("First occurence at index: "+first);
            System.out.println("Last occurence at index: "+last);
        }else{
            System.out.println("Number not found");
        }
    }
}