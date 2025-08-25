public class BinaryStrings {
    // function to print all the binary strings of length n without consecutive 1s

    // intuition/approach
    // n = 2
    // in first place put 0 -> 01,00
    // check the last place if its 0 then we can put 1 or 0 in the next place
    // but if the last place is 1 then we can only put 0 -> so that no 1's appear in consecutive manner

    public static void binaryString(int n ,   String str , int lastplace ){
        if(n == 0){
            System.out.println(str);
            return;
        }

        // now call the recursive function for n-1

        binaryString(n-1 ,str+"0" , 0);

        if(lastplace == 0){
            binaryString(n-1 , str+"1" ,1) ;
        }
    }
    public static void main(String[]args){
        binaryString(3," ",0);
    }
}
