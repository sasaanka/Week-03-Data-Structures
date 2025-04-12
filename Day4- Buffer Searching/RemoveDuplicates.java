import java.util.HashSet;
public class RemoveDuplicates{
    public static String removeDup(String text){
        StringBuilder result=new StringBuilder();
        HashSet<Character> seen=new HashSet<>();

        for(char ch:text.toCharArray()){
            if(!seen.contains(ch)){
                seen.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String text="Sasanka";
        System.out.println("Removing Duplicates: "+RemoveDuplicates.removeDup(text));
    }
}