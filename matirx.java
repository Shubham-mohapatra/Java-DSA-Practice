import java.util.*;
public class matirx{
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows : ");
        int rows  = sc.nextInt();
        System.out.println("Enter the number of cols : ");
        int cols = sc.nextInt();

        int[][]matrix = new int[rows][cols];
        System.out.println("Enter the elements in the matrix :  ");
        for(int i = 0;i<rows;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix");
        for(int i = 0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(matrix[i][j] + " ");
            }


            System.out.println();
        }
        

        // code to print the no of seven's in a 2d array 

        int count = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] == 7){
                    count++;
                }
            }
        }
        System.out.println("No of times 7 appear :  "+count);



        sc.close();
    }
    
}