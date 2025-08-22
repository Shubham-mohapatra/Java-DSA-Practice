public class FirstOccurence {
    public static int firstOccurence(int[]arr , int i , int key){
        // base case
        if(i== arr.length-1){
            return  -1;
        }
        if(arr[i] == key){
            return i; // return the index where key is found
        }
        return firstOccurence(arr,i+1,key);
    }
    public static void main(String []args){
        int key = 5;
        int[] arr = {8,3,6,9,5,10,2,5,3};

        System.out.println(firstOccurence(arr,0,5));
    }
}
