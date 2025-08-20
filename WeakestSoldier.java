import java.util.*;

public class WeakestSoldier {

    static class Row implements Comparable<Row> {
        int soldiers;
        int index;

        public Row(int soldiers, int index) {
            this.soldiers = soldiers;
            this.index = index;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) { // check if the number of soliders are equal in a row
                return this.index - r2.index; // if they are equal then sort on the basis of index (i<j)
            }
            return this.soldiers - r2.soldiers; // else sort them on the basis of soldiers
            // less soldiers - > weak
        }
    }

    public static void main(String[] args) {
        int k = 2;
        int[][] army = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
        };

        PriorityQueue<Row> pq = new PriorityQueue<>();

        // count soldiers in each row
        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                if (army[i][j] == 1) {
                    count++;
                }
            }
            pq.add(new Row(count, i));
        }

        // print k weakest rows
        for (int x = 0; x < k; x++) {
            System.out.println(pq.remove().index);
        }
    }
}
