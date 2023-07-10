/**
 * The selectionSort class implements the abstractSort interface and provides a selection sort algorithm to sort a myMap object based on the occurrence count of characters.
*/

public class selectionSort implements abstractSort{

    private myMap originalMap;
    private myMap sortedMap;
    private Character[] aux;

    /**
    * Constructs a selectionSort object with the specified myMap.
    *
    * @param map The myMap object to be sorted.
    */
    public selectionSort(myMap map) {
        originalMap = new myMap("");;
        sortedMap =  new myMap("");
        originalMap.getMap().putAll(map.getMap());
        aux = originalMap.getMap().keySet().toArray(new Character[0]);
    }

    /**
     * Sorts the myMap using the selection sort algorithm.
     * The sorting is based on the occurrence count of characters in the original myMap.
     */
    @Override
    public void sort(){
        long startTime = System.nanoTime();
        selection_sort(aux); // Calling mergeSort method on aux String.
        long endTime = System.nanoTime();
        long duration = (endTime - startTime); //divide by 1000000 to get milliseconds.
        System.out.printf("Running time: %d ns\n", duration);
    }

    /**
    * Performs the selection sort algorithm on the given array of characters.
    *
    * @param aux The array of characters to be sorted.
    */
    private void selection_sort(Character[] aux){
        for(int i = 0; i < aux.length - 1; ++i){
            int minIndex = i;
            for(int j = i + 1; j < aux.length; ++j){ 
                if(originalMap.getMap().get(aux[j]).getCount() < originalMap.getMap().get(aux[minIndex]).getCount()){
                    minIndex = j;
                }
            }
            char temp = aux[minIndex];
            aux[minIndex] = aux[i];
            aux[i] = temp;
        }
    }

    /**
    * Retrieves the sorted myMap object after the sorting operation has been performed.
    *
    * @return The sorted myMap object.
    */
    @Override
    public myMap getSortedMap(){

        for (int i=0; i< aux.length; ++i) {
            sortedMap.getMap().put(aux[i], originalMap.get(aux[i]));
        }
        return sortedMap;
    }
}