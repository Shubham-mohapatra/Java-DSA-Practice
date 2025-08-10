import java.util.*;

public class SourcetoTarget {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add (new Edge(0,3));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void printallPath(ArrayList<Edge>[]graph ,  int src , int dest , String path){
        // base case , when src == dest , print path - > curr node
        if(src == dest){
            System.out.println(path+=dest);
            return;
        }

        // if src != dest , find the neigbor of the curr node and perform printallPath function

        for(int i=0 ; i<graph[src].size(); i++){
            // calc the edge
            Edge e = graph[src].get(i);
            printallPath(graph , e.dest , dest , path+src);
        }
    }

    public static void printGraph(ArrayList<Edge>[]graph){
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (SourcetoTarget.Edge e : graph[i]) {
                System.out.print(e.dest + " ");
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);


        int src = 5;
        int target = 1;
        System.out.println("All the path from the source to target  : ");
        printallPath(graph ,5 ,1 , " ");
    }
}