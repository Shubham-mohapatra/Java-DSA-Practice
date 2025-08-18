import java.util.*;
public class Pq {
    // Priority Queue for Objects

    static class Student implements  Comparable<Student>{
        String name;
        int rank;

        public Student(String name , int rank){
            this.rank = rank;
            this.name = name;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank; // comaprsion on the basis of rank
            // sorts in ascending order

            // case1  -
            // result = -ve obj1(this) <  obj2(this)

            // case2 -
            // result = +ve obj1(this) >  obj2(this)

            // case 3 -
            // result = 0 obj1 =  obj2


        }
    }
    static class Heap{
        // heap implemented using ArrayList
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data); // add at last index

            int x = arr.size()-1; // x is the last index of the array
            int par = (x-1)/2; // to find the index of the par of element which needs to be inserted

            while(arr.get(x) < arr.get(par)){
                // swap both the elements
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par , temp);

                // update the child and the par index
                x = par;
                par = (x-1)/2;
            }
        }

        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx=i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){ // check if the left idx is out of arr.size()
                minIdx = left;

            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }

            // check
            if(minIdx != i){
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx ,temp);

                heapify(minIdx);
            }
        }




        // function to delete the element in a heap using heapfiy
        public int remove(){
            int data = arr.getFirst();

            // step 1  - swap first and the last element
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1 , temp);

            // delete the last element
            arr.remove(arr.size()-1);

            // heapify
            // compare the left and the right child of the current node
            heapify(0);
            return data;

        }

        // func to check if the heap is empty or not

        public boolean isEmpty(){
            return arr.size() == 0;
        }


        public int peek(){
            return arr.get(0);
        }


    }
    public static void main(String[]args){
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new  Student("Shubham" ,4)); // adding name with ranks in the priority queue
        pq.add(new  Student("Hello" ,1));
        pq.add(new  Student("XYZ" ,10));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name +  "->" +  pq.peek().rank);
            pq.remove();

        }
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(1);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }


    }
}
