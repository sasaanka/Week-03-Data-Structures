//BUbble sort
import java.util.Scanner;
public class Studentmarks{
    public void bubblesort(int[] marks){
        int n=marks.length;
        int temp;
        for(int i=0;i<n;i++){
            for (int j=0;j<n-i-1;j++){
                if(marks[j]>marks[j+1]){
                    temp=marks[j];
                    marks[j]=marks[j+1];
                    marks[j+1]=temp;
                }
            }
        }
        
    }
    public void printmarks(int[] marks){
        System.out.print("After sorting: ");
        for(int mark: marks){
            System.out.print(mark+" ");
        }
    }
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int num=inp.nextInt();

        int[] marks=new int[num];
        System.out.println("Enter the marks for "+num +"students.");
        for (int i=0;i<num;i++){
            System.out.print("Enter the marks of "+(i+1)+" student: ");
            marks[i]=inp.nextInt();
        }


        Studentmarks sort=new Studentmarks();
        sort.bubblesort(marks);
        sort.printmarks(marks);
    }
}