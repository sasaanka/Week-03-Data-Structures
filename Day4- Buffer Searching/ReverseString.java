import java.util.Scanner;
public class ReverseString{
    public static void main(String[] args) {
        StringBuilder s1=new StringBuilder();
        
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str=inp.nextLine();
        
        for(int i=str.length()-1;i>=0;i--){
            s1.append(str.charAt(i));
        }
        System.out.println("Reversed String: "+s1.toString());
    }
}