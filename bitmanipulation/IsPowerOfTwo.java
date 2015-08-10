public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        while ((n & 1) == 0 && n > 1)
            n = n >>> 1;
        return (n == 1);
    }
    
    public static void main (String[] args) {
        IsPowerOfTwo test = new IsPowerOfTwo ();
        System.out.println (test.isPowerOfTwo (2));
        System.out.println (test.isPowerOfTwo (3));
        System.out.println (test.isPowerOfTwo (64));
    }
}