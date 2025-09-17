import java.util.*;
public class Duplicate {
    public static boolean isDuplicate(int [] arr){
      for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++){
            if(arr[i] == arr[j]){
                return true;
            }
        }

       
    }
     return false;
            
    }


public static boolean isDuplicates(int[]arr){
    Set<Integer> set = new HashSet<>();
    for(int i=0;i<set.size();i++){

        if(set.contains(arr[i])){
            return false;
        }
        else{
            set.add(arr[i]);
        }
    }
    return true;
}

 public static void main(String[]args){
    int[] arr = {1,2,3,1};
    System.out.println(isDuplicates(arr));
    }
}
