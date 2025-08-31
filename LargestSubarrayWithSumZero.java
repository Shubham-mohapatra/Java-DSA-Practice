import java.util.HashMap;

public class LargestSubarrayWithSumZero {

    // find the largest subarray with sum as 0
    public static void main(String[]args){
        // approach is ->
        // create a hashmap to track the sum and its index (key -> sum , value-> idx)
        // find the sum till the jth index
        //arr[i] = 0;
        // check if the sum already exists in the hashmap
        // then find the j-i and compare with len to find the max len

        int []arr  =  {15,-2,2,-8,1,7,10};
        HashMap<Integer,Integer> subarr = new HashMap<>();
        int sum=0;
        int len=0;

        subarr.put(0, -1);


        // loop till the end of the array using j
        for(int j=0;j<arr.length;j++){
            // find the sum till jth index
            sum += arr[j];

            // check if the map already has the sum
            if(subarr.containsKey(sum)){
                // then compare len between len and j-i
                len = Math.max(len,j-subarr.get(sum));
            }else{
                // if the sum doesnt exist in the hashmap
                subarr.put(sum,j);
            }
        }
        System.out.println("Subarray with sum as 0 -> "+len);

    }
}
