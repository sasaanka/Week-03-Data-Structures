public class Mergesort{
    public void mergesort(int[] nums,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            mergesort(nums, l, m);
            mergesort(nums, m+1, r);
            merge(nums,l,m,r);
        }
    }
    private void merge(int[] nums, int l, int m, int r) {
        int n1=m-l+1;
        int n2=r-m;
        int[] larr=new int[n1];
        int[] rarr=new int[n2];
        for(int x=0;x<n1;x++){
            larr[x]=nums[l+x];
        }
        for(int x=0;x<n2;x++){
            rarr[x]=nums[m+1+x];
        }
        int i=0;
        int j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(larr[i]<rarr[j]){
                nums[k]=larr[i];
                i++;
            }else{
                nums[k]=rarr[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            nums[k]=larr[i];
            i++;
            k++;
        }
        while(j<n2){
            nums[k]=rarr[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        int[] nums={5,2,8,2,1,9};
        System.out.print("Before sorting: ");
        for(int num:nums){
            System.out.print(num+" ");
        }
        Mergesort l1=new Mergesort();
        l1.mergesort(nums, 0, nums.length-1);
        System.out.println();
        System.out.print("After sorting: ");
        for(int num:nums){
            System.out.print(num+" ");
        }
    }

    
}