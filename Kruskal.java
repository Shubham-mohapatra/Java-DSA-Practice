import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    static class Edge implements Comparable<Edge> {
        int src, dest, wt;
        Edge(int s, int d, int w) { this.src = s; this.dest = d; this.wt = w; }
        @Override public int compareTo(Edge e2) { return this.wt - e2.wt; }
    }

    // DSU (Disjoint Set Union) with path compression + union by rank
    static int[] par, rank;

    static void init(int n) {
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    static int find(int x) {
        if (par[x] != x) par[x] = find(par[x]); // path compression
        return par[x];
    }

    static void union(int aRoot, int bRoot) { // aRoot and bRoot must be roots
        if (aRoot == bRoot) return;
        if (rank[aRoot] == rank[bRoot]) {
            par[bRoot] = aRoot;
            rank[aRoot]++;
        } else if (rank[aRoot] > rank[bRoot]) {
            par[bRoot] = aRoot;
        } else {
            par[aRoot] = bRoot;
        }
    }

    static void createGraph(List<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    // Returns total MST weight (and prints chosen edges)
    static int kruskal(List<Edge> edges, int V) {
        Collections.sort(edges);
        init(V);

        int total = 0, picked = 0;
        for (Edge e : edges) {
            int ra = find(e.src), rb = find(e.dest);
            if (ra != rb) {
                union(ra, rb);
                total += e.wt;
                picked++;
                System.out.println("Pick edge: " + e.src + " - " + e.dest + " (" + e.wt + ")");
                if (picked == V - 1) break; // MST complete
            }
        }
        return total;
    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);

        int V = 4; // vertices 0..3
        int mstWeight = kruskal(edges, V);
        System.out.println("MST total weight = " + mstWeight);
    }
}
