import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

/**
 * An implementation of a graph that uses an array of lists to represent the
 * edges
 * 
 * @author R.A.
 *
 */
public class CSE222Graph {

    private Map<String, List<String>> graph; // First String is the vertex, second String is the list of adjacent
                                             // vertices

    private int numV = 0;
    private int column;
    private int row;
    private int start_point_x;
    private int start_point_y;
    private int end_point_x;
    private int end_point_y;

    public CSE222Graph(CSE222Map map) {
        start_point_x = map.start_point_x;
        start_point_y = map.start_point_y;
        end_point_x = map.end_point_x;
        end_point_y = map.end_point_y;
        this.row = map.getR();
        this.column = map.getC();
        graph = new HashMap<String, List<String>>();
        createGraph(map);
    }

    public String getStartPoint() {
        return start_point_x + "," + start_point_y;
    }

    public String getEndPoint() {
        return end_point_x + "," + end_point_y;
    }

    public int getNumRows() {
        return row;
    }

    public int getNumColumns() {
        return column;
    }

    public Set<String> getVertices() {
        return graph.keySet();
    }

    public List<String> getNeighbors(String vertex) {
        return graph.get(vertex);
    }

    private void createGraph(CSE222Map map) {
        for (int i = 0; i < map.getR(); ++i) {
            for (int j = 0; j < map.getC(); ++j) {
                List<String> adj = new ArrayList<String>();
                if (map.matrix[i][j].equals("0")) {
                    numV++;
                    if (isValid(i, j - 1, map) && map.matrix[i][j - 1].equals("0")) {
                        adj.add(i + "," + (j - 1));
                    }
                    if (isValid(i, j + 1, map) && map.matrix[i][j + 1].equals("0")) {
                        adj.add(i + "," + (j + 1));
                    }
                    if (isValid(i + 1, j, map) && map.matrix[i + 1][j].equals("0")) {
                        adj.add((i + 1) + "," + j);
                    }
                    if (isValid(i - 1, j, map) && map.matrix[i - 1][j].equals("0")) {
                        adj.add((i - 1) + "," + j);
                    }
                    if (isValid(i - 1, j - 1, map) && map.matrix[i - 1][j - 1].equals("0")) {
                        adj.add((i - 1) + "," + (j - 1));
                    }
                    if (isValid(i - 1, j + 1, map) && map.matrix[i - 1][j + 1].equals("0")) {
                        adj.add((i - 1) + "," + (j + 1));
                    }
                    if (isValid(i + 1, j - 1, map) && map.matrix[i + 1][j - 1].equals("0")) {
                        adj.add((i + 1) + "," + (j - 1));
                    }
                    if (isValid(i + 1, j + 1, map) && map.matrix[i + 1][j + 1].equals("0")) {
                        adj.add((i + 1) + "," + (j + 1));
                    }
                    if (!graph.containsKey(i + "," + j))
                        graph.put(i + "," + j, adj);

                }
            }
        }
    }

    public int getNumV() {
        return numV;
    }

    public void printGraph() {
        // print the graph
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private boolean isValid(int i, int j, CSE222Map map) {
        if (i < 0 || i >= map.getR() || j < 0 || j >= map.getC()) {
            return false;
        }
        return true;
    }

    public boolean isEdge(String source, String dest) {
        return graph.get(source).contains(dest);
    }

    public List<String> getEdge(String vertex) {
        if (graph.containsKey(vertex)) {
            return graph.get(vertex);
        } else {
            return new ArrayList<String>(); // Return an empty list if the vertex is not found
        }
    }

    public Map<String, List<String>> getGraph() {
        return graph;
    }

}
