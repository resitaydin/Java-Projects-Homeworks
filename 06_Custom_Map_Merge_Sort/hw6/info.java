package hw6;
import java.util.ArrayList;

/**
 * The info class represents a list of words and the count of those words.
 * It provides methods for adding words to the list, getting the current count, and printing out the list of words.
 */
public class info{

    private int count;
    private ArrayList<String> words;
    
    /**
     * Constructs a new info object with an empty list of words and count set to zero.
     */
    public info(){
        count = 0;
        words = new ArrayList<>();
    }
    /**
     * Adds a new word to the list of words and increments the count of words.
     * @param word the word to add to the list
     */
    public void push(String word){
        try{
            words.add(word);
            count++;
        } catch (OutOfMemoryError e) {
            System.err.println("Caught OutOfMemoryError: " + e.getMessage());
            words.clear();
        }
    }
    /**
     * Prints out the current count and the list of words stored in the object.
     */

    public void printInfo(){
        System.out.print("Count: " + count + " - Words : [");
        for(int i=0; i< words.size(); ++i){
            if(i != words.size() - 1){
                System.out.print(words.get(i) + ", ");
            }
            else System.out.print(" " + words.get(i));
        }
        System.out.print("]");
    }

    /**
     * Returns the current count of words in the object.
     * @return the count of words
     */
    public int getCount(){
        return count;
    }
}

