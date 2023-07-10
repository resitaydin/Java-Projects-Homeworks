/**
 * The bubbleSort class implements the abstractSort interface and provides a bubble sort algorithm to sort a myMap object based on the occurrence count of characters.
*/

public class bubbleSort implements abstractSort{
    private myMap originalMap;
    private myMap sortedMap;
    private Character[] aux;

        /**
         * Constructs a bubbleSort object with the specified myMap.
         *
         * @param map The myMap object to be sorted.
         */
        public bubbleSort(myMap map) {
            originalMap = new myMap("");;
            sortedMap =  new myMap("");
            originalMap.getMap().putAll(map.getMap());
            aux = originalMap.getMap().keySet().toArray(new Character[0]);
        }

        /**
        * Sorts the myMap using the bubble sort algorithm.
        * The sorting is based on the occurrence count of characters in the original myMap.
        */
        @Override
        public void sort(){
            long startTime = System.nanoTime();
            bubble_sort(aux);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime); //divide by 1000000 to get milliseconds.
            System.out.printf("Running time: %d ns\n", duration);
        }

        /**
        * Performs the bubble sort algorithm on the given array of characters.
        *
        * @param aux The array of characters to be sorted.
        */
        private void bubble_sort(Character[] aux){
            int size = aux.length;
            char temp = ' ';

            for(int i = 0; i < size; ++i){
                for(int j = 1; j < size - i; ++j){
                    if(originalMap.getMap().get(aux[j-1]).getCount() > originalMap.getMap().get(aux[j]).getCount()){
                        temp = aux[j-1];
                        aux[j-1] = aux[j];
                        aux[j] = temp;
                    }
                }
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