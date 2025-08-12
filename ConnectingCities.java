import java.util.PriorityQueue;

public class ConnectingCities {

    // use prims algo(mst) to find the min cost to connect all the cities
    //Priority queue -> store the dest vertex and the cost to reach that vertex from the curr node
    // find the total cost
    // visited array to track if a node is already visited or not
    // finally return the total cost

    static class Edges implements Comparable<Edges>{
        int dest;
        int cost;

        public Edges(int d , int c){
            this.dest = d;
            this.cost = c;
        }
        @Override
        public int compareTo(Edges e2){ // when sorting an object of a class we dont know the parameter on which basis it should be sorted
            // user comparable interface
          return this.cost - e2.cost;
        }
    }

    // in mst we call the edge cost

    public static int connectCities(int [][] cities){
        int totalcost = 0;
        boolean [] visited = new boolean[cities.length];
        PriorityQueue<Edges> pq  = new PriorityQueue<>(); // in pq we have to sort the objects

        // src
        pq.add(new Edges(0,0));
        while(!pq.isEmpty()){
            Edges curr = pq.remove(); // remove the curr element
            if(!visited[curr.dest]){ // check if the curr element destination is visited or not
                visited[curr.dest] = true;
                totalcost += curr.cost; // add the edge cost to the total cost

                // for loop to find the neigbors
                for(int i=0;i<cities[curr.dest].length;i++){
                    if(cities[curr.dest][i] != 0){
                        pq.add(new Edges(i , cities[curr.dest][i]));

                    }
                }

            }
        }


        return totalcost;
    }

    public static void main(String[]args){
        int [][] cities = {{0,1,2,3,4},
                {1,0,5,0,7},
                {2,5,0,6,0},
                {3,0,6,0,0},
                {4,7,0,0,0},
        };

        System.out.println(connectCities(cities));
    }
}
