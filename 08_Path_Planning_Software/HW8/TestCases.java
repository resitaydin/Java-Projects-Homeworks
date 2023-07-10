import java.util.List;

public class TestCases implements Runnable {

    private String FileName;
    private int X_SIZE;
    private int Y_SIZE;

    public TestCases(String FileName, int X_SIZE, int Y_SIZE) {
        this.FileName = FileName;
        this.X_SIZE = X_SIZE;
        this.Y_SIZE = Y_SIZE;
    }

    public void test() {

        System.out.println("\n\n*******************\nMap is " + this.FileName + " with X_SIZE " + this.X_SIZE
                + " and Y_SIZE " + this.Y_SIZE + "\n********************\n");
        CSE222Map Map = new CSE222Map(this.FileName, this.X_SIZE, this.Y_SIZE);
        CSE222Graph Graph = new CSE222Graph(Map);

        CSE222BFS BFS = new CSE222BFS(Graph);
        List<String> BFSPath = BFS.findPath();
        Map.convertPNG();
        Map.drawLine(BFSPath);
        Map.writePath(BFSPath);
        System.out.println("BFS Path: " + BFS.length);

        // CSE222Dijkstra Dijkstra = new CSE222Dijkstra(Graph); // Dijkstra's Algorithm
        // unfortunately doesn't work.
        // List<String> DijkstraPath = Dijkstra.findPath();
        // Map.drawLine(DijkstraPath);
        // Map.writePath(DijkstraPath);
        // System.out.println("Dijkstra Path: " + Dijkstra.length);

    }

    @Override
    public void run() {
        test();
    }
}
