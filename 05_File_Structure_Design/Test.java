/**
 * The Test class is used to demonstrate the usage of the FileHierarchy class. It creates an instance of FileHierarchy, reads data from a file, converts the data into a tree structure,
 * visualizes the tree, and performs various search operations on the tree.
 * To execute the test, run the main method in this class.
 */

public class Test {

    /**
    The main method creates an instance of FileHierarchy, reads data from a file, converts the data into a tree structure,

    visualizes the tree, and performs various search operations on the tree.

    * @param args the command-line arguments
*/
    public static void main(String[] args) {
        
        FileHierarchy myFileH = new FileHierarchy("tree.txt");
        myFileH.readFromFile();
        myFileH.arrayToTree();
        myFileH.printTheImage();

        myFileH.BFS("CSE232");
        myFileH.BFS("CSE2332");

        myFileH.DFS("CSE232");
        myFileH.DFS("CSE2332");

        myFileH.postOrderTraversal("CSE232");
        myFileH.postOrderTraversal("CSE2332");
    }
}
