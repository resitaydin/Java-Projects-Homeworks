import java.util.*;
import java.util.HashMap;

public class CSE222Dijkstra {
    private CSE222Graph graph;
    private Map<String, String> previous;
    private Map<String, Integer> distances;
    private PriorityQueue<String> unvisited;
    protected int length;

    public CSE222Dijkstra(CSE222Graph graph) {
        this.graph = graph;
        previous = new HashMap<>();
        distances = new HashMap<>();
        unvisited = new PriorityQueue<>(Comparator.comparingInt(distances::get));
    }

    public List<String> findPath() {
        String start = graph.getStartPoint();
        String end = graph.getEndPoint();

        for (String vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
            unvisited.add(vertex);
        }
        distances.put(start, 0);

        while (!unvisited.isEmpty()) {
            String current = unvisited.poll();
            if (current.equals(end)) {
                break;
            }
            for (String neighbor : graph.getNeighbors(current)) {
                int distance = distances.get(current) + 1;
                if (distance < distances.get(neighbor)) {
                    distances.put(neighbor, distance);
                    previous.put(neighbor, current);
                }
            }
        }

        List<String> path = buildPath(previous, start, end);
        length = path.size();
        return path;
    }

    private List<String> buildPath(Map<String, String> pred, String start, String end) {
        List<String> path = new ArrayList<>();
        String current = end;

        // Check if there is a valid path to the end point
        if (!pred.containsKey(current)) {
            return path; // Return an empty list if there is no valid path
        }

        while (current != null) {
            path.add(0, current);
            current = pred.get(current);
        }

        if (!path.get(0).equals(start)) {
            path.clear(); // If there is no path to the end point, return an empty list
        }

        return path;
    }
}
