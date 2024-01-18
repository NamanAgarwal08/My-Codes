import java.util.HashMap;
import java.util.Set;

public class hashmap {
    //Operations:
    // 1. => put(key,value)     O(1)
    // 2. => get(key)           O(1)
    // 3. => containsKey(key)   O(1)
    // 4. => remove(key)        O(1)

    public static void main(String args[]) {

        HashMap<String, Integer> map = new HashMap<>();
        
        //Insert
        map.put("India",100);
        map.put("China",150);
        map.put("US", 50);
    
        System.out.println(map);

        
        // //Get
        // int indiaPopulation = map.get("India");
        // System.out.println(indiaPopulation);
        // //if any key is entered which is not present, null is returned.
        // System.out.println(map.get("Indonesia"));


        // //containsKey
        // System.out.println(map.containsKey("India")); //true
        // System.out.println(map.containsKey("Indonesia")); //false


        // //Remove
        // System.out.println(map.remove("China"));
        // System.out.println(map);
        // // if any key is entered which is not present, null is returned.
        // System.out.println(map.remove("Indonesia"));
        // System.out.println(map);


        // //Size
        // System.out.println(map.size());


        // //isEmpty()
        // System.out.println(map.isEmpty());


        // //clear (clears the map)
        // map.clear();
        // System.out.println(map.isEmpty());


        //Iterate (to get all key-value pair : map.keySet())
        Set<String> keys = map.keySet();
        System.out.println(keys);
        for (String str : keys) {
            System.out.println(str+" -> "+map.get(str));
        }
    }
}