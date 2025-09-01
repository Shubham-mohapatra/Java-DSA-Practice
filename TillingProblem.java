public class TillingProblem {
    // function to calc the number ways to fill the floor of size 2 X n with 2x1 size tiles

    public static int fillTiles(int n){
        //base case
        if( n== 0 || n== 1){
            return 1; // no of ways when n becomes 0 or 1 is 1
        }

        // now we have two choices to fill the tiles on the floor

        //1) vertical placement
        int vertical = fillTiles(n-1);  // recursively call the func to fill the tiles in vertical manner

        // 2)horizontal placement
        int horizontal = fillTiles(n-2);


        return vertical+horizontal;
    }



    public static void main(String[]args){
        System.out.println("No of ways to fill the area of the floor : "+fillTiles(3));
    }
}
