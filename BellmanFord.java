import java.util.*;

public class BellmanFord {

    static class Edge {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Create the graph using a single edge list
    public static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 2, 4));

        edges.add(new Edge(1, 2, 1));
        edges.add(new Edge(1, 3, 7));

        edges.add(new Edge(2, 4, 3));

        edges.add(new Edge(3, 5, 1));

        edges.add(new Edge(4, 3, 2));
        edges.add(new Edge(4, 5, 5));
    }

    public static void bellmanFord(ArrayList<Edge> edges, int V, int src) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        // Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (Edge e : edges) {
                if (distance[e.src] != Integer.MAX_VALUE && distance[e.src] + e.wt < distance[e.dest]) {
                    distance[e.dest] = distance[e.src] + e.wt;
                }
            }
        }

        // Check for negative weight cycles
        for (Edge e : edges) {
            if (distance[e.src] != Integer.MAX_VALUE && distance[e.src] + e.wt < distance[e.dest]) {
                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }

        // Print shortest distances
        for (int i = 0; i < V; i++) {
            System.out.println("Shortest path from " + src + " to " + i + " is " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        int src = 0;
        ArrayList<Edge> edges = new ArrayList<>();

        createGraph(edges);
        bellmanFord(edges, V, src);
    }
}
