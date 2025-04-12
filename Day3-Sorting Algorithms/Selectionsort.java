public class Selectionsort{
    public static void main(String[] args) {
        int[] nums={34,10,54,254,10,69,102};
        int temp;
        int size=nums.length;
        int minIndex;
        System.out.println("Before Sorting: ");
        for(int num:nums){
            System.out.print(num+" ");
        }

        for(int i=0;i<size;i++){
            minIndex=i;
            for(int j=i+1;j<size;j++){
                if(nums[minIndex]>nums[j]){
                    minIndex=j;
                }
            }
            temp=nums[minIndex];
            nums[minIndex]=nums[i];
            nums[i]=temp;
        }
       System.out.println();

        System.out.println("After Sorting: ");
        for(int num:nums){
            System.out.print(num+" ");
        }

        
    }
}