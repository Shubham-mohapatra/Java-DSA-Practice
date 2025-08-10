import java.lang.reflect.Array;
import java.util.*;
public class Dijisktra {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src ,  int dest , int wt) {
            this.src = src;
            this .dest = dest;
            this.wt = wt;

        }
    }
     public static void createGraph(ArrayList<Edge>[]graph){
        for(int i=0;i< graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add (new Edge(0,1,2));
        graph[0].add (new Edge(0,2,4));

         graph[1].add (new Edge(1,2,1));
         graph[1].add (new Edge(1,3,7));

         graph[2].add (new Edge(2,4,3));
         graph[3].add (new Edge(3,5,1));

         graph[4].add (new Edge(4,3,2));
         graph[4].add (new Edge(4,5,5));


     }

    static class Pair implements Comparable<Pair> {
        int node, dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist; // min-heap based on distance
        }
    }


     public static void dijikstra(ArrayList<Edge>[]graph , int src ){
        int distance[] = new int[graph.length]; // dist[i] ->  src -> i
         for(int i=0;i< graph.length;i++){
             // base case if src == i , do nothing
             if(i != src){
                 distance[i] = Integer.MAX_VALUE; // mark all the nodes from the source as infinte

             }

         }
         // visited array to track the nodes
         boolean visited[] = new boolean[graph.length];

         PriorityQueue<Pair> pq =  new PriorityQueue<>();

         //src->src dist = 0
         pq.add(new Pair(src , 0));

         // dfs loop
         while(!pq.isEmpty()){ // while the priority queue is not empty
             Pair curr = pq.remove();
             if(!visited[curr.node]){
                 visited[curr.node] = true; // if the curr.node is not visited , mark it as visited
                 // update the distance of the curr.node
                 for(int i=0;i< graph[curr.node].size();i++){
                     Edge e = graph[curr.node].get(i);
                     int u =  e.src;
                     int v = e.dest;
                     int wt = e.wt;

                     // core dijisktra logic
                     // dist[u] + wt(u,v) < dist[v]
                     // then dist[v] = dist[u] + wt(u,v)

                     if(distance[u] + wt < distance[v]){
                         distance[v] = distance[u] + wt; // updated the distance of src to v;

                         // add the new pair in the pq
                         pq.add(new Pair(v,distance[v]));
                     }
                 }
             }

         }

         // print all source to vertices shorted dist

         for(int i=0;i<distance.length;i++){
             System.out.println("Shortest path : "  +distance[i]);
         }
         System.out.println();
     }








    public static void main(String[] args){
        int V = 6;
        int src = 0;
        ArrayList<Edge>[]graph = new ArrayList[V];
        createGraph(graph);

        dijikstra(graph , 0);
    }
}
