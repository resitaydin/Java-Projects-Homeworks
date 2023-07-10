/**
 * Main class that has main method to test the functions of each class.
*/

public class main{
    /**
     * Main method to test the functions of each class.
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {

        String strBestCase = new String("a cccc dddddd eeeeeee ffffffff"); 
        String strAvrgCase = new String("aaaaa bbbbbbbb cccc eee fffffff d"); 
        String strWorstCase = new String("aaaaaaaa bbbbbbb cccccc dddd eee"); 
        
        strBestCase = strBestCase.replaceAll("[^ \\w]", "").toLowerCase();
        strAvrgCase = strAvrgCase.replaceAll("[^ \\w]", "").toLowerCase();
        strWorstCase = strWorstCase.replaceAll("[^ \\w]", "").toLowerCase();
        //replacing all characters excluding " " and any word character.

        System.out.printf("Preprocessed String: \t%s\n\n\n", strBestCase);
        System.out.printf("Preprocessed String: \t%s\n\n\n", strAvrgCase);
        System.out.printf("Preprocessed String: \t%s\n\n\n", strWorstCase);

        myMap mapBest = new myMap(strBestCase);
        myMap mapAvrg = new myMap(strAvrgCase);
        myMap mapWorst = new myMap(strWorstCase);

        // // BEST CASES

        System.out.println("\n\n------------------- BEST CASES ---------------------");

        System.out.println("\n\nThe original (unsorted) map: ");
        mapBest.printMap();

        System.out.println("\nSorting the map using Merge Sort (Best Case)...");
        mergeSort sortMergeB = new mergeSort(mapBest);
        sortMergeB.sort();

        System.out.println("\nSorting the map using Selection Sort (Best Case)...");
        selectionSort sortSelectionB = new selectionSort(mapBest);
        sortSelectionB.sort();

        System.out.println("\nSorting the map using Insertion Sort (Best Case)...");
        insertionSort sortInsertionB = new insertionSort(mapBest);
        sortInsertionB.sort();

        System.out.println("\nSorting the map using Bubble Sort (Best Case)...");
        bubbleSort sortBubbleB = new bubbleSort(mapBest);
        sortBubbleB.sort();

        System.out.println("\nSorting the map using Quick Sort (Best Case)...");
        quickSort sortQuickB = new quickSort(mapBest);
        sortQuickB.sort();

        System.out.println("\n\nThe sorted map: ");
        sortSelectionB.getSortedMap().printMap();

        // /////////////////////////////////////////////////////////////////////

        // // AVERAGE CASES

        System.out.println("\n\n------------------- AVERAGE CASES ---------------------");

        System.out.println("\n\nThe original (unsorted) map: ");
        mapAvrg.printMap();

        System.out.println("\nSorting the map using Merge Sort (Average Case)...");
        mergeSort sortMergeA = new mergeSort(mapAvrg);
        sortMergeA.sort();


        System.out.println("\nSorting the map using Selection Sort (Average Case)...");
        selectionSort sortSelectionA = new selectionSort(mapAvrg);
        sortSelectionA.sort();
        

        System.out.println("\nSorting the map using Insertion Sort (Average Case)...");
        insertionSort sortInsertionA = new insertionSort(mapAvrg);
        sortInsertionA.sort();


        System.out.println("\nSorting the map using Bubble Sort (Average Case)...");
        bubbleSort sortBubbleA = new bubbleSort(mapAvrg);
        sortBubbleA.sort();


        System.out.println("\nSorting the map using Quick Sort (Average Case)...");
        quickSort quickMergeA = new quickSort(mapAvrg);
        quickMergeA.sort();

        System.out.println("\n\nThe sorted map: ");
        quickMergeA.getSortedMap().printMap();

        // /////////////////////////////////////////////////////////////////////

        // // WORST CASES

        System.out.println("\n\n------------------- WORST CASES ---------------------");

        System.out.println("\n\nThe original (unsorted) map: ");
        mapWorst.printMap();

        System.out.println("\nSorting the map using Merge Sort (Worst Case)...");
        mergeSort sortMergeW = new mergeSort(mapWorst);
        sortMergeW.sort();

        System.out.println("\nSorting the map using Selection Sort (Worst Case)...");
        selectionSort sortSelectionW = new selectionSort(mapWorst);
        sortSelectionW.sort();

        System.out.println("\nSorting the map using Insertion Sort (Worst Case)...");
        insertionSort sortInsertionW = new insertionSort(mapWorst);
        sortInsertionW.sort();

        System.out.println("\nSorting the map using Bubble Sort (Worst Case)...");
        bubbleSort sortBubbleW = new bubbleSort(mapWorst);
        sortBubbleW.sort();

        System.out.println("\nSorting the map using Quick Sort (Worst Case)...");
        quickSort sortQuickW = new quickSort(mapWorst);
        sortQuickW.sort();

        System.out.println("\n\nThe sorted map: ");
        sortInsertionW.getSortedMap().printMap();

        /////////////////////////////////////////////////////////////////////

        System.out.println("\n\n------------- Testing a different case --------------\n\n");
        
        String str = new String("'Hush, hush!' whispered the rushing wind.");
        System.out.printf("Original String: \t%s\n", str);
        str = str.replaceAll("[^ \\w]", "").toLowerCase();

        myMap map = new myMap(str);
        
        System.out.println("\n\nThe original (unsorted) map: ");
        map.printMap();

        System.out.println("\nSorting the map using Merge Sort...");
        mergeSort sortMerge = new mergeSort(map);
        sortMerge.sort();

        System.out.println("\n\nThe sorted map: ");
        sortMerge.getSortedMap().printMap();

        System.out.println("\nSorting the map using Selection Sort...");
        selectionSort sortSelection = new selectionSort(map);
        sortSelection.sort();

        System.out.println("\n\nThe sorted map: ");
        sortSelection.getSortedMap().printMap();

        System.out.println("\nSorting the map using Insertion Sort...");
        insertionSort sortInsertion = new insertionSort(map);
        sortInsertion.sort();

        System.out.println("\n\nThe sorted map: ");
        sortInsertion.getSortedMap().printMap();

        System.out.println("\nSorting the map using Bubble Sort...");
        bubbleSort sortBubble = new bubbleSort(map);
        sortBubble.sort();

        System.out.println("\n\nThe sorted map: ");
        sortBubble.getSortedMap().printMap();

        System.out.println("\nSorting the map using Quick Sort...");
        quickSort sortQuick = new quickSort(map);
        sortQuick.sort();

        System.out.println("\n\nThe sorted map: ");
        sortQuick.getSortedMap().printMap();

    }
}