public class SpecificWord{
    public static String search(String[] sentences,String word){
        for(String sentence:sentences){
            if(sentence.contains(word)){
                System.out.println("The Word "+word+" is in "+sentence);
            }
        }
        return "Not found";
    }
    public static void main(String[] args) {
        String[] sentences={"Sasanka is from AP"," She is learning Java","She is placed in CG"};
        SpecificWord.search(sentences, "Java");
    }
}