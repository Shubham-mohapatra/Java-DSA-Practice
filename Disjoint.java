public class Disjoint {
    static int  n = 7;
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static  void init(){
        // will be used to initialze parent
        // initial -  every element is parent of its own
        for(int i=0;i<n;i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        // function to find the parent of each element
        if( x == par[x]){
            return x;
        }
        return find(par[x]);
    }

    public static void union(int a , int b){ // function to find the union
        // 3 cases
        int parA = find(a);
        int parB = find(b);

        // case 1 -
        if(rank[parA] == rank[parB]){ // if the both elements have the same rank , anyone can be parent of each other
            par[parB] = parA;
            rank[parA]++;
        } // case-2
        else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        }
        else{
            par[parA] = parB;
        }

    }

    public static void main(String[] args){
        init();
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);




    }
}
