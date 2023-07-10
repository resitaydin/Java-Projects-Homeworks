package hw6;
/**
 * MainClass is the entry point for the application and is responsible for
 * demonstrating the use of myMap and mergeSort classes.
 */
public class MainClass{
    /**
     * The main method is the entry point for the application.
     * It creates a myMap object to store the character frequency count of a given string.
     * It then creates a mergeSort object to sort the character frequency map.
     * Finally, it prints out the original and sorted maps.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        String str = new String("'Hush, hush!' whispered the rushing wind");
        System.out.printf("Original String: \t%s\n", str);
        
        str = str.replaceAll("[^ \\w]", "").toLowerCase();
        // replacing all characters excluding " " and any word character.

        System.out.printf("Preprocessed String: \t%s\n\n\n", str);

        myMap map = new myMap(str);
        System.out.println("The original (unsorted) map: ");
        map.printMap();

        mergeSort sortMap = new mergeSort(map);
        sortMap.MergeSort();
        System.out.println("\n\n\nThe sorted map: ");
        sortMap.getSortedMap().printMap();
    }
}
