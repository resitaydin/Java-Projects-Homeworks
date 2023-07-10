package hw6;
/**
 * A class that performs a merge sort on a myMap object, sorting the elements by their values.
 */

public class mergeSort{

    private myMap originalMap;
    private myMap sortedMap;
    private Character[] aux;

    /**
     * Constructor that initializes the original map, the sorted map, and the auxiliary array.
     * @param map the original map to be sorted
     */
    public mergeSort(myMap map){
        originalMap = new myMap("");
        originalMap.getMap().putAll(map.getMap());
        sortedMap = new myMap("");
        aux = originalMap.getMap().keySet().toArray(new Character[0]);
    }

    /**
    * Sorts the array of elements.
    */
    public void MergeSort() {
        MergeSort(aux); // Calling mergeSort method on aux String.
    }

    /**
     * Recursively sorts the array of elements using merge sort.
     * @param input the array of elements to be sorted
     */
    private void MergeSort(Character[] input){
        int i,j;

        int length = input.length;
        int midIndex = length / 2;
        Character[] left = new Character[midIndex];
        Character[] right = new Character[length - midIndex];

        if(length<2){
            return;
        }

        try{
            for (i=0; i < midIndex; ++i) {
                left[i] = input[i];
            }
    
    
            for (j= midIndex; j < length; ++j) {
                right[j - midIndex] = input[j];
            }
    
            MergeSort(left);
            MergeSort(right);
            merge(input, left, right);

        } catch (Exception e) {
            System.out.println("Error occurred during merge sort: " + e.getMessage());
        }

    }

    /**
     * Merges two arrays of elements into a single, sorted array.
     * @param input the input array
     * @param leftHalf the left half of the array to be merged
     * @param rightHalf the right half of the array to be merged
     */
    private void merge(Character[] input, Character[]  leftHalf, Character[]  rightHalf){
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;

        try{
            while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
                if (originalMap.get(leftHalf[leftIndex]).getCount() <= originalMap.get(rightHalf[rightIndex]).getCount()) {
                    input[index] = leftHalf[leftIndex];
                    leftIndex++;
                } else {
                    input[index] = rightHalf[rightIndex];
                    rightIndex++;
                }
                index++;
            }
    
            while (leftIndex < leftHalf.length) {
                input[index] = leftHalf[leftIndex];
                leftIndex++;
                index++;
            }
        
            while (rightIndex < rightHalf.length) {
                input[index] = rightHalf[rightIndex];
                rightIndex++;
                index++;
            }
        } catch (Exception e) {
            System.out.println("Error occurred during merging: " + e.getMessage());
        }
    }

     /**
     * Returns the sorted map.
     * @return the sorted map
     */
    public myMap getSortedMap(){

        for (int i=0; i< aux.length; ++i) {
            sortedMap.getMap().put(aux[i], originalMap.get(aux[i]));
        }
        return sortedMap;
    }

}
