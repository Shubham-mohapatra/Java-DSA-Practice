import java.lang.reflect.Array;
import java.util.*;

public class Topological {

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
            graph[2].add(new Edge(2 , 3 ));
            graph[3].add(new Edge(3 , 1 ));
            graph[4].add(new Edge(4 , 0 ));
            graph[4].add(new Edge( 4, 1 ));

            graph[5].add(new Edge(5 , 0));
            graph[5].add(new Edge(5 , 2 ));
    }

    public static void Topologicalsort(ArrayList<Edge>[] graph){
        boolean [] visited =  new boolean[graph.length]; // visited array to track changes
        // stack
        Stack<Integer> st = new Stack<>();

        for(int i=0;i< graph.length;i++){
            if(!visited[i]){
                topSortUtil(graph , i , visited , st); // modified dfs
            }
        }

        while(!st.isEmpty()){
            System.out.println(st.pop()); // pop the elements from the stack
        }

    }

    public static void topSortUtil(ArrayList<Edge>[] graph , int curr , boolean[] visited ,  Stack<Integer> st){
        visited[curr] = true;

        // find the neigbor and if neigbor is not visited , visit it and add the curr to the stack

        for(int i=0;i< graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topSortUtil(graph,e.dest , visited ,st);
            }
        }

        // add the curr to the stack
        st.push(curr);
    }

    public static void printGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print(e.dest + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        printGraph(graph);
        Topologicalsort(graph);

    }
}
