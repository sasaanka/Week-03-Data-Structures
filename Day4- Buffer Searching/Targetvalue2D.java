public class Targetvalue2D{
    public static boolean search(int[][] nums,int target){
        int rows=nums.length;
        int cols=nums[0].length;
        int left=0;
        int right=rows*cols-1;
        while(left<=right){
            int mid=(left+right)/2;
            int row=mid/cols;
            int col=mid%cols;
            int midValue=nums[row][col];
            if(midValue==target){
                return true;
            }else if(midValue>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] nums={
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target=20;
        if(search(nums, target)){
            System.out.println("Target "+target+" is found in array.");
        }else{
            System.out.println("Taregt not found");
        }
    }
}