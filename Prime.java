import java.util.*;
public class Prime {
    // Function to check if a number is prime
    public static boolean isPrime(int n) {
        int count = 0 ;
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        count++;
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int primeCount = 0;
        for (int num : arr) {
            boolean prime = isPrime(num);
            if (prime) {
                primeCount++;
            }
        }
        System.out.println("Total number of primes: " + primeCount);
    }
}
