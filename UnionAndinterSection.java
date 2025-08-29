import java.util.HashMap;
import java.util.HashSet;

public class UnionAndinterSection {
    // func to find the union of the arr1 and arr2

    public static int union(int[]arr1 , int[]arr2){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++) {
            set.add(arr2[i]);
        }
        return set.size();
    }


    // func to find the intersection of arr1 and arr2

    public static int intersection(int[]arr1 , int[] arr2){
    // add the arr1 elements to the set
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }

        // loop over arr2 array to check if the arr2 element is already present in the set
        // if present increment the counter and remove the element from the set
        int count=0;
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }
        return count;
    }

    public static void main(String[]args){
        int[] arr1 = {7,3,9};
        int[]arr2 = {6,3,9,2,9,4};
        int union = union(arr1,arr2);
       int intersection =  intersection(arr1,arr2);
       System.out.println(union);
       System.out.println(intersection);
    }
}
