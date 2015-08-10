import java.util.HashMap;
import java.lang.Math;

public class CountPrimes {
    public int countPrimes(int n) {
        int result = 0;
        if (n <= 3) {
            if (n == 0 || n == 1 || n == 2) return 0;
            else if (n == 3) return 1;
        }
        boolean[] isPrime = new boolean[n];
        isPrime[0] = false;
        isPrime[1] = false;
        isPrime[2] = true;
        for (int i = 3; i < n; i++) {
            isPrime[i] = i % 2 == 0 ? false : true;    // set multiples of 2 to false
        }
        for (int i = 3; i <= Math.ceil (Math.sqrt (n)); i += 2) {
            int multiplier = 3;
            while (i * multiplier < n) {
                isPrime[i * multiplier] = false;
                multiplier += 2;
            }
        }
        for (boolean entry : isPrime) 
            if (entry) result++;
        return result;
    }
    
    public static void main (String[] args) {
        CountPrimes test = new CountPrimes ();
        System.out.println (test.countPrimes (1000));
    }
}