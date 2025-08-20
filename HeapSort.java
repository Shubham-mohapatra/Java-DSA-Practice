import java.util.*;
public class HeapSort {


    public static void heapsort(int arr[]){
        int n = arr.length;
        // step -1  -> build the maxheap
        // loop for the non leaf nodes or last completely filled nodes
        for(int i = n/2; i >=0 ;i--){
            // call the heapify function
            heapify(arr , i , n);
        }
        for(int i = n-1; i>0;i--){
            // swap the largest with last index
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr ,0 , i);
        }
    }

    public static void heapify( int [] arr , int i , int n){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxindx = i;

        // check
        if(left < n && arr[left] < arr[maxindx]){
            maxindx = left;
        }
        if(right < n && arr[right] < arr[maxindx]){
            maxindx = right;
        }
        if(maxindx != i){
            int temp = arr[i];
            arr[i] = arr[maxindx];
            arr[maxindx] = temp;

            heapify(arr ,maxindx ,n);

        }
    }



    public static void main(String[] args){
        int arr[] = {1,2,3,4,5};
        heapsort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
}
