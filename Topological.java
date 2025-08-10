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


    // Topological sort using bfs
    // indegree of each node is calculated  and stored in an array
    // Queue to store the nodes having indegree 0
    // remove the curr element from the q and the indegree of its neigbor will be indeg--
    // insert the neigbor node and repeat the process



    public static void findIndeg(ArrayList<Edge>[]graph , int[] indeg){
        // loop through the nodes of the graph
        for(int i=0;i< graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                // Find the edge
                Edge e  =  graph[i].get(j);
                indeg[e.dest]++; // indegree will be increased by 1
            }
        }
    }

    // Top sortBFS

    public static void TopSortbfs(ArrayList<Edge>[]graph){
        int [] indeg = new int[graph.length];
        findIndeg(graph , indeg); // find the indeg
        Queue<Integer> q = new LinkedList<>();

        // insert the element in the queue having the indeg  = 0

        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        // Iterate over the queue

        while(!q.isEmpty()){
            // print the curr element
            int curr = q.remove();
            System.out.println( " "+curr);

            // find the neigbors of the curr element of the curr elemenet and add them to the queue
            for(int i=0 ; i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--; // decrement the indegree of the neigbors
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }

        }
        System.out.println();

    }






    // Topological sort using dfs

    public static void Topologicalsort(ArrayList<Edge>[] graph){
        boolean [] visited =  new boolean[graph.length]; // visited array to track changes
        // stack
        Stack<Integer> st = new Stack<>();

        // for connected components
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
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        printGraph(graph);
        System.out.println("Topological sort using DFS  : ");
        Topologicalsort(graph);
        System.out.println("Topological sort using BFS  : ");
        TopSortbfs(graph);

    }
}
