package hw6;
import java.util.LinkedHashMap;
import java.util.Map;

/**
This class represents a map that stores information about the occurrence of characters in a given string.
*/
public class myMap{
    
    private LinkedHashMap<Character,info> map;
    private int mapSize;
    private String str;

    /**
    Constructor that initializes the map with the given string.
    @param s The string to build the map from.
    */
    public myMap(String s){
        mapSize = 0;
        str = s;
        map = new LinkedHashMap<>(mapSize);
        add();
    }

    /**
    Adds the occurrence information for each character in the string to the map.
    */
    private void add(){
        String parts[] = str.split(" ");
        info inf = new info();
        try{
            for(String part: parts){
            
                for(int i=0; i<part.length(); ++i){
                    char ch = part.charAt(i);
                    if(!map.containsKey(ch)){
                        inf = new info();
                        inf.push(part);
                        map.put(ch, inf);
                        mapSize++;
                    }
                    else{
                        info in = map.get(ch);
                        in.push(part);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
    Prints the mapping of characters to their occurrence information.
    */
    public void printMap(){
        for (Map.Entry<Character, info> entry : map.entrySet()) {
            Character key = entry.getKey();
            info value = entry.getValue();
            System.out.printf("Letter: %s - ", key);
            value.printInfo();
            System.out.println();
        }
    }
    /**
     * Returns the size of the map.
     * @return The size of the map
     */
    public int size(){
        return mapSize;
    }

    /**
    Returns the map.
    @return The LinkedHashMap that stores the mapping of characters to their occurrence information.
    */
    public LinkedHashMap<Character,info> getMap(){
        return map;
    }

    /**
    Returns the occurrence information for a given character.
    @param key The character to get the occurrence information for.
    @return The occurrence information for the given character.
    */
    public info get(Character key) {
        return map.get(key);
    }
}
