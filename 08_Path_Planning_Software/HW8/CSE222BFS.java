import java.util.*;
import java.util.HashMap;

public class CSE222BFS {

    private CSE222Graph graph;
    private Map<String, String> previous;
    private Set<String> visited;
    protected int length;

    public CSE222BFS(CSE222Graph graph) {
        this.graph = graph;
        previous = new HashMap<>();
        visited = new HashSet<>();
    }

    public List<String> findPath() {
        String start = graph.getStartPoint();
        String end = graph.getEndPoint();

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (String neighbor : graph.getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    previous.put(neighbor, current); // add neighbor to previous map
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        List<String> path = new ArrayList<>();
        String current = end;
        while (current != null) {
            path.add(current); // add current to path
            current = previous.get(current);
        }
        Collections.reverse(path);
        length = path.size();
        return path;
    }
}
