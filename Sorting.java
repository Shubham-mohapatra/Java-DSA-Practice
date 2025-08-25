public class Sorting {
    // bubble sort  - >O(n^2)

    public static void bubbleSort(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // swap
                if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                    swaps ++;

            }

        }
    }

        System.out.println("No of swaps : "+swaps);

}

// func to print the array

    public static void printarray(int[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i] + " ");

        }

    }

    // selection sort func -> O(n^2)
    public static void selectionSort(int []arr){
        int n = arr.length;
        for(int i=0;i<arr.length-1;i++){
            int min = i;  // curr element is min
            for(int j=i+1;j<arr.length;j++){
                if(arr[min] > arr[j]){
                    min = j; // find the min in the undsorted part and swap with the curr min element in the sorted part
                }
            }
            // swap the elements
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

        }
    }
    // insertion sort  - > O(n^2)

    public static void inserstionSort(int []arr){
        for(int i=1;i<arr.length-1;i++){
            int curr = arr[i];
            int prev = i-1;
            // find out the correct position to insert
            while(prev >= 0  && arr[prev] > curr){
                arr[prev+1] =  arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }


    public static void main(String[]args){
        int [] arr = {1,2,3,4,5};
        inserstionSort(arr);
        printarray(arr);
    }

}
