import java.util.HashMap;
public class HashMap1{
    public static void main(String[] args) {
        HashMap<String, Integer> map=new HashMap<>();
        map.put("Sasanka",10);
        map.put("Bharath",02);
        map.put("Abhi",30);

    System.out.println("Sasankas ID: "+map.get("Sasanka"));
    if (map.containsKey("Abhi")) {
            System.out.println("Abhi is in the list.");
        }

        // Iterating over the map
        for (String name : map.keySet()) {
            System.out.println(name + " scored " + map.get(name));
        }
    if(map.containsKey("Bharath")){
        System.out.println("key is removed: "+map.remove("Bharath"));
    }
    System.out.println("ALL values: "+map.keySet());
    System.out.println("Entry set: "+map.entrySet());
    System.out.print("HAsh map size: "+map.size());
}
}
    
    
