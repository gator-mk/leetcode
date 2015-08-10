public class IsPalindromeNumber {
    public boolean isPalindrome(int x) {
        int n = x;
        int digit = 0;
        int rev = 0;
        while (x > 0) {
            digit = x % 10;
            rev = rev * 10 + digit;
            x = x / 10;
        }
        return n == rev;
    }
    
    public static void main (String[] args) {
        IsPalindromeNumber test = new IsPalindromeNumber ();
        System.out.println (test.isPalindrome (21));
        System.out.println (test.isPalindrome (1221));
        System.out.println (test.isPalindrome (12121));
        System.out.println (test.isPalindrome (0));
    }
}