/**
* The quickSort class implements the abstractSort interface and provides a quick sort algorithm to sort a myMap object based on the occurrence count of characters.
*/
public class quickSort implements abstractSort{
    private myMap originalMap;
    private myMap sortedMap;
    private Character[] aux;
    
        /**
        * Constructs a quickSort object with the specified myMap.
        *
        * @param map The myMap object to be sorted.
        */
        public quickSort(myMap map) {
            originalMap = new myMap("");;
            sortedMap =  new myMap("");
            originalMap.getMap().putAll(map.getMap());
            aux = originalMap.getMap().keySet().toArray(new Character[0]);
        }

        /**
        * Sorts the myMap using the quick sort algorithm.
        * The sorting is based on the occurrence count of characters in the original myMap.
        */
        @Override
        public void sort(){
            long startTime = System.nanoTime();
            quick_sort(aux, 0, aux.length - 1);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime); //divide by 1000000 to get milliseconds.
            System.out.printf("Running time: %d ns\n", duration);
        }

        /**
        * Partitions the array based on the occurrence count of characters.
        *
        * @param arr  The array of characters to be partitioned.
        * @param low  The index of the low boundary.
        * @param high The index of the high boundary.
        * @return The index of the partition.
        */
        private int partition(Character arr[], int low, int high) {
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (originalMap.getMap().get(arr[j]).getCount() <= originalMap.getMap().get(arr[high]).getCount()) {
                    i++;
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            char temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            return i + 1;
        }
    
        /**
        * Performs the quick sort algorithm on the given array of characters.
        * @param arr  The array of characters to be sorted.
        * @param low  The index of the low boundary.
        * @param high The index of the high boundary.
        */
        private void quick_sort(Character arr[], int low, int high) {
            if (low < high) {
                int p = partition(arr, low, high);
                quick_sort(arr, low, p - 1);
                quick_sort(arr, p + 1, high);
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