public class FriendsPairing {
    public static int pairs(int n){
        int res = 0;
        // base case
        // when there is a single person or when there are 2 person -> they can be paired in n way
        if( n == 1 || n == 2){
            return n;
        }
        int single  =  pairs(n-1);
        int pair   = (n-1) * pairs(n-2);


        res = pair + single; // total no of ways that can be formed


        return res;
    }
    public static void main(String[]args){
       System.out.println( pairs(4));
    }
}
