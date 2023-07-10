import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import java.io.File;
import java.io.FileNotFoundException;

/**
* The FileHierarchy class represents a solution for organizing file paths into a hierarchical tree structure and provides methods to search for specific files within the tree.
* It reads data from a file, converts the data into a tree structure, visualizes the tree, and offers search algorithms such as breadth-first search (BFS), depth-first search (DFS), and post-order traversal.
* The class utilizes the DefaultMutableTreeNode and JTree classes from the javax.swing.tree package for constructing and visualizing the tree structure.
* The class provides the following functionalities:
* Reading data from a file and storing it in a data structure.
* Converting the data into a hierarchical tree structure.
* Visualizing the tree structure using a graphical window.
* Searching for a specific file using BFS, DFS, or post-order traversal algorithms.
* To use this class, create an instance by providing the name of the file containing the file paths.
* Then, call the readFromFile() method to read the data from the file.
* Next, call the arrayToTree() method to convert the data into a tree structure.
* Finally, you can visualize the tree structure by calling the printTheImage() method, and perform searches using the BFS(), DFS(), or postOrderTraversal() methods.
 */

public class FileHierarchy{

   private ArrayList<ArrayList<String>> data;
   private String txtName;
   private JTree myTree;
   private DefaultMutableTreeNode root;
   private JFrame frame;

   /**
     * Constructs a new FileHierarchy object with the specified file name.
     * Initializes the data field as an empty ArrayList of ArrayLists of Strings,
     * sets the txtName field to the specified file name, creates a new JTree with
     * a root node named "Root", and sets the root and myTree fields accordingly.
     *
     * @param fileName the name of the file to be used by this FileHierarchy object
     */
   FileHierarchy(String fileName){
        data = new ArrayList<ArrayList<String>>();
        txtName = fileName;
        root = new DefaultMutableTreeNode("Root");
        myTree = new JTree(root); // Creating a tree which has "Root" as root.
   }

   /**
 * Reads data from the file specified by the txtName field and stores it in the data field.
 * Each line of the file is split into elements using the semicolon (;) delimiter and added
 * to an ArrayList of Strings. Each ArrayList of Strings is then added to the data field.
 */
public void readFromFile(){
    try{
        String line = "";
        ArrayList<String> row ; 
        Scanner scanner = new Scanner(new File(txtName));
        while(scanner.hasNextLine()){
            row = new ArrayList<>();
            line = scanner.nextLine();
            String[] elements = line.split(";");

            for(String str : elements){
                row.add(str);
            }
            data.add(row);
        }
        scanner.close();
        }
    catch(FileNotFoundException e){
        e.printStackTrace();
    }
}

/**
 * Creates a new JFrame and adds the JTree specified by the myTree field to it.
 * Sets the title, size, and other properties of the JFrame and makes it visible.
 */

public void printTheImage(){
    frame = new JFrame();
    frame.add(myTree);
    frame.setTitle("Files Hiearchy Tree");
    frame.setSize(400, 400);
    frame.setResizable(true);
    frame.setVisible(true);
}
/**
 * Converts the data stored in the data field into a tree structure and stores it in the myTree field.
 * Each ArrayList of Strings in the data field represents a path from the root of the tree to a leaf node.
 * For each path, the method iterates through the nodes and checks if a child node with the same name
 * already exists. If it does, the method moves to that child node. If it doesn't, the method creates
 * a new child node with the specified name and adds it to the current node. The method then moves to
 * the new child node and continues processing the path.
 */

public void arrayToTree(){
    for(int i=0; i<data.size(); ++i){
        DefaultMutableTreeNode parentNode = root;
        for(int j=0; j<data.get(i).size(); ++j){
            String nodeName = data.get(i).get(j);
            DefaultMutableTreeNode node = null;
            for (int k = 0; k < parentNode.getChildCount(); k++) {
                DefaultMutableTreeNode child = (DefaultMutableTreeNode) parentNode.getChildAt(k);
                if (child.getUserObject().equals(nodeName)) {
                    node = child;
                    break;
                }
            }
            if(node == null){
                node = new DefaultMutableTreeNode(nodeName);
                parentNode.add(node);
            }
            parentNode = node;
        }
    }
}


/**
 * Searches for the specified string in the tree using breadth-first search (BFS).
 * The method starts at the root of the tree and visits all its child nodes before
 * moving to the next level of the tree. The method prints each node it visits and
 * returns true if the string is found in the tree, false otherwise.
 *
 * @param str the string to search for in the tree
 * @return true if the string is found in the tree, false otherwise
 */

public boolean BFS(String str){
    System.out.printf("Using BFS to find '%s' in the tree...\n", str);

    Queue <DefaultMutableTreeNode> que = new LinkedList<>();
    que.add(root);

    int counter = 0;

    while(!que.isEmpty()){

    DefaultMutableTreeNode currentNode = que.remove();
        if(currentNode.getUserObject().equals(str)){
            System.out.printf("Step %d -> %s (Found!)\n", counter+1, currentNode.toString() );
            return true;
        }
        else{
            System.out.printf("Step %d -> %s\n", counter+1, currentNode.toString() );
            for (int k = 0; k < currentNode.getChildCount(); k++) {
                que.add((DefaultMutableTreeNode) currentNode.getChildAt(k));
            }
        }
        counter++;
    }
    System.out.println("Not found.");
    return false;
}


/**
 * Searches for the specified string in the tree using depth-first search (DFS).
 * The method starts at the root of the tree and visits all its child nodes before
 * backtracking to its parent node. The method prints each node it visits and
 * returns true if the string is found in the tree, false otherwise.
 *
 * @param str the string to search for in the tree
 * @return true if the string is found in the tree, false otherwise
 */
public boolean DFS(String str){
    System.out.printf("Using DFS to find '%s' in the tree...\n", str);

    Stack <DefaultMutableTreeNode> stck = new Stack<>();
    stck.add(root);

    int counter = 0;

    while(!stck.isEmpty()){

    DefaultMutableTreeNode currentNode = stck.pop();
        if(currentNode.getUserObject().equals(str)){
            System.out.printf("Step %d -> %s (Found!)\n", counter+1, currentNode.toString() );
            return true;
        }
        else{
            System.out.printf("Step %d -> %s\n", counter+1, currentNode.toString() );
            for (int k = 0; k < currentNode.getChildCount(); k++) {
                stck.add((DefaultMutableTreeNode) currentNode.getChildAt(k));
            }
        }
        counter++;
    }
    System.out.println("Not found.");
    return false;
}

/**
 * Helper function that searches for the specified string in the tree using post-order traversal.
 * The method starts at the specified node and visits all its child nodes before
 * visiting the node itself. The method prints each node it visits and returns -1
 * if the string is found in the tree, the current index otherwise.
 *
 * @param node the node to start the search from
 * @param str the string to search for in the tree
 * @param index the current index of the search
 * @return -1 if the string is found in the tree, the current index otherwise
 */


private int postOrderTraversalSearch(DefaultMutableTreeNode node, String str, int index) {
    int currentIndex = index;
    if (node != null) {
        for (int i = 0; i < node.getChildCount(); ++i) {
            DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
            currentIndex = postOrderTraversalSearch(childNode, str, currentIndex);
            if (currentIndex == -1) {
                return -1;
            }
            System.out.printf("Step %d -> %s\n", currentIndex , childNode.toString());
        }
        currentIndex++;
        if (node.getUserObject().toString().equals(str)) {
            System.out.printf("Step %d -> %s (Found!)\n", currentIndex , node.toString());
            return -1;
        }
    }
    return currentIndex;
}

/**
 * Searches for the specified string in the tree using post-order traversal.
 * The method starts at the root of the tree and visits all its child nodes before
 * visiting the root node. The method prints each node it visits and returns true
 * if the string is found in the tree, false otherwise. If the string is not found,
 * the method prints "Not found".
 *
 * @param str the string to search for in the tree
 * @return true if the string is found in the tree, false otherwise
 */

public boolean postOrderTraversal(String str) {
    System.out.printf("Using Post-Order traversal to find '%s' in the tree...\n", str);
    int finalIndex = postOrderTraversalSearch(root, str, 0);
    if (finalIndex != -1) {
        System.out.println("Not found.");
    }
    return finalIndex == -1;  // Returns true if the string was found, false otherwise
}


} // End of Class
