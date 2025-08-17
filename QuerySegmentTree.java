public class QuerySegmentTree {
    static int tree[]; //

    public static void  init(int n){ // init func to initalize the tree
        tree = new int[4*n];
    }

    // func to build segment tree
    public static int buildtree(int[]arr,int sti,int start,int end){
        // base case
        if (start == end){
            tree[sti] = arr[start];
            return arr[start];
        }

        // calc the mid

        int mid = (start+end)/2;
        //left child
        buildtree(arr,2*sti+1 ,start,mid);

        //right child
        buildtree(arr,2*sti+2,mid+1,end);

        //left child + right child = curr node

        tree[sti] = tree[2*sti+1] + tree[2*sti+2];


        return tree[sti];

    }

    // helper function for getSum
    public static int getSumUtil(int i , int si , int sj , int qi , int qj){
        // check the bases cases

        // case 1 -  non overlapping with the segment tree array
        if(qj <= si || qi >= sj){
            return 0;
        } else if (si >= qi && sj <= qj) { // case 2 -> complete overlap
           return tree[i];
            
        }
        else{ // case 3 -partial overlap
            // find the mid
            int mid = (si+sj)/2;
            // recursively find the left subtree and the right subtree

            int left = getSumUtil(2*i+1 , si ,mid,qi,qj);
            int right = getSumUtil(2*i+2 , mid+1 ,sj,qi,qj);
                return  left+right;

        }
    }


    public static int getSum(int[]arr , int qi , int qj){
        int n = arr.length;
       return getSumUtil(0,0,n-1,qi,qj);

       // starting index of segm tree array =0
        // ending index -> n-1


    }


    public static void main(String[]args){
        int[] arr = {1,2,3,4,5,6,7,8,};
        int n = arr.length;
        init(n);
        buildtree(arr,0,0,n-1);
        System.out.println(getSum(arr,2,5));

    }
}
