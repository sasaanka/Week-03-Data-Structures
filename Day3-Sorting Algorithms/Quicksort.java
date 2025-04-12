public class Quicksort{
    public void quicksort(int[] arr,int low,int high){
            if(low<high){
                int pivot=partition(arr,low,high);
                quicksort(arr, low,pivot-1 );
                quicksort(arr, pivot+1, high);
            }
        }
    private static int partition(int[] arr, int low,int high){
        int pivot=arr[high];
        int i=low-1;

        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr={85,153,48,20,33};
        System.out.println("Before sorting: ");
        for(int num:arr){
            System.out.print(num+" ");
        }
        Quicksort s1=new Quicksort();
        s1.quicksort(arr, 0, arr.length-1);
        System.out.println();
        System.out.println("After sorting: ");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}