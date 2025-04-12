public class Insertionsort{
    public static void main(String[] args) {
        int[] nums={4,2,7,8,1};
        int len=nums.length;
        System.out.print("Before sorting: ");
        for(int num: nums){
            System.out.print(num+" ");
        }
        //sorting
        for (int i=1;i<len;i++){
            int key=nums[i];
            int j=i-1;
            while(j>=0 && nums[j]>key ){
                nums[j+1]=nums[j];
                j=j-1;
            }
            nums[j+1]=key;
        }
        System.out.println();
        System.out.print("After sorting: ");
        for(int num: nums){
            System.out.print(num+" ");
        }
    }
}