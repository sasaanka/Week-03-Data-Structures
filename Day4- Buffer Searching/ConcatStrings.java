public class ConcatStrings{
    public static String concat(String[] words){
        @SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer result=new StringBuffer();
        for(String word:words){
            result.append(word).append(" ");
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String[] words={"Sasanka","is","a","good","girl"};
        System.out.println(ConcatStrings.concat(words));
    }
}