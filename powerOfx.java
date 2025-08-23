public class powerOfx {

    // optimized approach to calculate the power of x
    //O(log n)
    public static int  pow(int x , int n){
        //base case
        if(n == 0){
            return 1;
        }
        int pow  =  pow(x , n/2);
        int res = pow * pow;

        // now if n is odd
        if(n %2 != 0){
            res =  x * pow * pow;
        }

        return res;
    }



    public static void main(String[]args){
        int x = 2;
        int n = 10;

        System.out.println(pow(2,10));
    }
}
