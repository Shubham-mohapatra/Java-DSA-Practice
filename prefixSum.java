public class prefixSum {
    public static void maxSubarraySum(int numbers[]){
        int currSum = 0;
        int maxSum  = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];


        prefix[0] = numbers[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i] = prefix[i-1] + numbers[i];
        }
        for(int i=0;i<numbers.length;i++){
            for(int j=i;j<numbers.length;j++){
                currSum = i==0 ? prefix[j] : prefix[j] - prefix[i-1];
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }

            int start = 0, end = 0;
            System.out.println("The maxSum of the subarray is  : "+maxSum);
            for(int k = start; k <= end; k++) {
                System.out.print(numbers[k] + " ");
            }
            System.out.println();
            for(int i=0;i<numbers.length;i++){
                for(int j=i;j<numbers.length;j++){
                    currSum = i==0 ? prefix[j] : prefix[j] - prefix[i-1];
                    if(maxSum < currSum){
                        maxSum = currSum;
                        start = i;
                        end = j;
                    }
                }
            }
            System.out.print("Subarray with maxSum: ");
            for(int k = start; k <= end; k++) {
                System.out.print(numbers[k] + " ");
            }
            System.out.println();
    }



    public static void main(String[]args){
        int[] numbers = {1,-2,6,-1,3};
        maxSubarraySum(numbers);
    }
}
