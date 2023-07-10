package vLDLinkedList;

import java.util.AbstractList;
import java.util.List;

/** LDLinkedList class which is basically a linked list class expect it uses lazy 
 *  deletion strategy to remove an element from the linked list.
 */

public class LDLinkedList<E> extends AbstractList<E> implements List<E>{

    /** A reference to list head. */
    private Node <E> head = null;
    /** The number of items in the list. */
    private int size=0;

    private int lazilyDeletedC=0;

    /** Add an item to the front of the list.
    @param item The item to be added
    */
    public void addFirst(E item){
        head = new Node<>(item, head);
        size++;
    }

    /** Add a node after a given node
    @param node The node preceding the new item
    @param item The item to insert
    */
    private void addAfter(Node<E> node, E item){
        if(node==null) {
            throw new NullPointerException();
        }
        node.next = new Node<>(item, node.next);
        size++;
    }


    @Override
    /** Overrided remove method that is implemented using lazy deleted strategy.
     *  @param item The object to be removed.
     * @return A boolean value about the succession of the removing operation.
     */
    public boolean remove(Object item){ // Actual remove method to be used in the functions.
        Node<E> node = search(item);
        if (node == null || node.lazilyDeleted) {
            return false; // item not found or already removed
        }
        node.lazilyDeleted = true;
        lazilyDeletedC++;

        Node<E> temp = head;
        if (lazilyDeletedC > 1) {
            temp = head;
            while (temp != null) {
                if (temp.lazilyDeleted) {
                    removeCurrentNode(temp);
                }
                temp = temp.next;
            }
            lazilyDeletedC = 0;
        }
        return true;
    }   
    

    /** Remove the node after a given node
    @param node The node before the removed one
    @return The data from the removed node, or null
    if there is no node to remove
    */
    private void removeCurrentNode(Node<E> node){
        if (node == null) {
            return;
        }
        if (node == head) {
            head = head.next;
        } else {
            Node<E> current = head;
            while (current != null && current.next != node) {
                current = current.next;
            }
            if (current == null) {
                return;
            }
            current.next = node.next;
        }
        size--;
    }
    /** Find the node at a specified position
    @param index The position of the node sought
    @return The node at index or null if it does not exist
    */
    private Node<E> getNode(int index){
        Node <E> node = head;
        int counter = 0;
        while(counter!= index && node!=null){
            node = node.next;
            counter++;
        }
        return node;
    }

    /** Find the specified object and return the node consists the item.
     * @param item Object to be found.
     * @return null if object is not found.
     */

    private Node<E> search(Object item){
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /** Get the data at index
    @param index The position of the data to return
    @return The data at index
    @throws IndexOutOfBoundsException if index is out of range
    */

    @Override
    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        Node<E> temp = getNode(index);
        return temp.data;
    }

    
    /** Store a reference to anEntry in the element at position index.
    @param index The position of the item to change
    @param newValue The new data
    @return The data previously at index
    @throws IndexOutOfBoundsException if index is out of range
    */

    @Override
    public E set(int index, E newValue){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node <E> node = getNode(index);

        E result = node.data;
        node.data = newValue;
        return result;
    }

    /** Insert the specified item at index
    @param index The position where item is to be inserted
    @param item The item to be inserted
    @throws IndexOutOfBoundsException if index is out of range
    */

    @Override
    public void add(int index, E item){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        if(index==0) addFirst(item);

        else{
            Node<E> node = getNode(index-1);
            addAfter(node, item);
        }
    }

    /** Append item to the end of the list
    @param item The item to be appended
    @return true (as specified by the Collection interface)
    */

    @Override
    public boolean add(E item) {
        add(size, item);
            return true;
    }


    /** Iterates over the linked-list, calculates the size and returns it.
     */
    @Override
    public int size(){
        Node <E> node = head;

        int counter = 0;
        while(node!=null){
            node = node.next;
            counter++;
        }

        return counter;
    }

    /** A Node is the building block for a single‐linked list. */
    private static class Node <E>{
        /** The reference to the data. */
        private E data;

        /** The reference to the next node. */
        private Node <E> next;

        private boolean lazilyDeleted;

        /** Creates a new node with a null next field.
        @param dataItem The data stored
        */
        private Node(E dataItem){
            data = dataItem;
            next = null;
            lazilyDeleted = false;
        }
        /** Creates a new node that references another node.
        @param dataItem The data stored.
        @param nodeRef The node referenced by new node.
        */
        private Node (E dataItem, Node<E> ref){
            data = dataItem;
            next = ref;
            lazilyDeleted = false;
        }
    }   
}
