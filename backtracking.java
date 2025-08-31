import java.util.*;
public class backtracking {
    public static void backtrack(int[] arr, int i, int val) {
        // base case
        // if the i becomes arr.length  ->  print the arr and return

        if(i == arr.length){
            printarr(arr);
            return;
        }
        // recursion + backtracking
        arr[i] = val;  // add the value at the index
        // call the recursive function
        backtrack(arr,i+1,val+1); // next call;
        // backtracking step
        arr[i] = arr[i] - 2;

    }

    public static void printarr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // backtracking basics
        // given an empty array
        // fill the array and subtract -2 at each index while backtracking
        // Step 1: take size of array
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        backtrack(arr,0,1);
        printarr(arr);
    }

}

