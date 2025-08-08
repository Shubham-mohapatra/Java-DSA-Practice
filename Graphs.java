import java.util.*;

public class Graphs {
    static class Edge { // Edge class is created 
        int src;
        int dest;

        public Edge(int s, int d) { // Constructor
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) { // Cycle detction in directed graph
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 3));


    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfsUtil(graph, visited);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] visited) { //O(V+E)
        Queue<Integer> q = new LinkedList<>();

        q.add(0); // Start BFS from vertex 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        System.out.println(curr + " "); // print the curr element
        visited[curr] = true; // mark the curr element as true

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // base case
            // check if the neighbor is already visited
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }


    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        dfsUtil(graph, curr, visited);
    }


    // Cycle detection in undirected graph

    // modifed dfs
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, visited, 0, -1)) { // if it returns true then only cycle exists
                    return true;           // cycle exists in one of the part
                }
            }
        }
        return false; //-> cycle not detected
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent) {
        visited[curr] = true; // curr node is marked as visited

        // traverse the neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            // 3 cases to detect cycle in a graph

            //  neigbor is not visited
            Edge e = graph[curr].get(i);  // get the edge
            if (!visited[e.dest] && detectCycleUtil(graph, visited, e.dest, curr)) { // if this return true
                return true;
            }
            // case1 : when neighbor is visited and e.dest != parent return true
            else if (visited[e.dest] && e.dest != parent) {
                return true;
            }
            // case 2 - > do nothing
        }
        return false;
    }

    // Cycle detection in directed graph

    public static boolean directedisCycle(ArrayList<Edge>[] graph) {
        // initialze two arrays - > visited , recursion stack

        boolean[] visted = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length ];

        // modifed DFS for connected components

        for (int i = 0; i < graph.length; i++) {
            // check if i is not visited
            if (!visted[i]) {
                if (directedisCycleUtil(graph, i, visted, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean directedisCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, boolean[] stack) {
        // perform modifed dfs
        // mark the curr node in visited array as true
        visited[curr] = true;
        stack[curr] = true;

        // loop over the neigbors

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case 1 -> if the neigbor of the curr node already exists in the stack
            // => cycle exists - > return true

            if (stack[e.dest]) {
                return true;
            }
            if (!visited[e.dest] && directedisCycleUtil(graph, e.dest, visited, stack)) {
                return true; // this will recursively check if the cycle exists in the call stack
            }
        }
        stack[curr] = false; // remove the node from the stack
        return false;
    }




    // code for bipartite graph

    public static boolean isBarptite(ArrayList<Edge>[]graph){
        int [] color = new int[graph.length];
            for(int i=0;i<graph.length;i++){
                // every vertex will not have any color = -1
                color[i] = -1;
            }
            Queue<Integer> q = new LinkedList<>();

            for(int i=0;i< graph.length;i++){ // this loop is for the cond when a graph can have different components
                if(color[i] == -1){ // BFS
                    q.add(i);
                    color[i] = 0; // yellow

                    while(!q.isEmpty()){
                        int curr = q.remove();
                        for(int j=0;j<graph[curr].size();j++){
                            // find the neigbor
                            Edge e =  graph[curr].get(j); // e.dest -> neighbor


                            // 3 cases to check
                            // case 1  -  if color[e.dest] = -1 -> give color

                            if(color[e.dest] == -1){
                                int nextColor = color[curr] == 0 ? 1 : 0;
                                color[e.dest] = nextColor;
                                q.add(e.dest); // next node is added to the queue
                            }

                            // case 2 -
                            // color[e.dest] is same as curr color

                            else if(color[e.dest] == color[curr]){
                                return false ; // not a bipartite graph
                            }


                        }
                    }
                }

            }
            return  true;
    }


    public static void main(String[] args) {
        int V = 4; // no of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
        System.out.println("\nBFS Traversal:");
        bfs(graph);
        
        System.out.println("\nDFS Traversal : ");
        dfs(graph , 0 , new boolean[V]);

        System.out.println(STR."Cycle detected for undirected graph : \{detectCycle(graph)}");

        // bipartite graph
        System.out.println(STR."The Graph is bipartite :  \{isBarptite(graph)}");

        System.out.println(STR."Cycle detected for directed graph : \{directedisCycle(graph)}");
    }
}
