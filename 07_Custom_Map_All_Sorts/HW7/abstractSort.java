/**
 * The abstractSort interface represents a contract for classes that implement sorting functionality for a myMap object.
 * Classes implementing this interface are expected to provide a way to sort the original myMap and retrieve the sorted version.
 */

interface abstractSort {
     /**
     * Sorts the original myMap according to a specific sorting algorithm.
     * The implementation of this method should not modify the original myMap instance but instead modify the sorted map.
     */
    void sort();
    /**
     * Retrieves the sorted myMap object after the sorting operation has been performed.
     *
     * @return The sorted myMap object.
     */
    myMap getSortedMap();

}
