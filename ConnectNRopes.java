import java.util.*;

public class ConnectNRopes {
    public static int minCost(int[]arr){
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int rope : arr){
            pq.add(rope);
        }

        // check the cond if the size of the heap > 1
        while(pq.size() > 1){
        int min1 = pq.poll(); // retireive the min element from the pq
        int min2 = pq.poll();
         int total  = min1 + min2;
         cost += total;
         pq.add(cost);
        }
        return cost;
    }



        public static void main(String[]args){
            int[] ropes = {4,3,2,6};
            System.out.println(minCost(ropes));
        }
}
