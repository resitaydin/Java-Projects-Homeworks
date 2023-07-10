/**
 * The insertionSort class implements the abstractSort interface and provides a insertion sort algorithm to sort a myMap object based on the occurrence count of characters.
 */

public class insertionSort implements abstractSort{
    private myMap originalMap;
    private myMap sortedMap;
    private Character[] aux;
    
        /**
        * Constructs a insertionSort object with the specified myMap.
        *
        * @param map The myMap object to be sorted.
        */
        public insertionSort(myMap map) {
            originalMap = new myMap("");;
            sortedMap =  new myMap("");
            originalMap.getMap().putAll(map.getMap());
            aux = originalMap.getMap().keySet().toArray(new Character[0]);
        }


        /**
        * Sorts the myMap using the insertion sort algorithm.
        * The sorting is based on the occurrence count of characters in the original myMap.
        */
        @Override
        public void sort(){
            long startTime = System.nanoTime();
            insertion_sort(aux);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime); //divide by 1000000 to get milliseconds.
            System.out.printf("Running time: %d ns\n", duration);
        }

        /**
        * Performs the insertion sort algorithm on the given array of characters.
        *
        * @param aux The array of characters to be sorted.
        */
        private void insertion_sort(Character[] array) {
            int size = array.length;
        
            for (int step = 1; step < size; step++) {

              char key = array[step];
              int j = step - 1;
        
              while (j >= 0 && originalMap.getMap().get(key).getCount() < originalMap.getMap().get(array[j]).getCount()) {
                array[j + 1] = array[j];
                --j;
              }
        
              array[j + 1] = key;
            }
        }

        /**
        * Retrieves the sorted myMap object after the sorting operation has been performed.
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