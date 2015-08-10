import java.util.Arrays;

public class OnePlus {
    /**
    Given a non-negative number represented as an array of digits, plus one to the number.
    The digits are stored such that the most significant digit is at the head of the list.
    */
    public int[] plusOne(int[] digits) {
        int length = 0;
        int lastCarry = 1;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            carry = (digits[i] + lastCarry) >= 10 ? 1 : 0;
            digits[i] = (digits[i] + lastCarry) % 10;
            lastCarry = carry;
        }
        int newLength = (carry == 1) ? digits.length + 1 : digits.length;
        int[] result = new int[newLength];
        if (newLength == digits.length) {
            for (int i = 0; i < newLength; i++) {
                result[i] = digits[i];
            }
        } else {
            result[0] = carry;
            for (int i = 0, j = 1; i < digits.length; i++, j++)
                result[j] = digits[i];
        }
        return result;
    }
    
    public static void main (String[] args) {
        OnePlus test = new OnePlus ();
        int[] in = {9,9};
        System.out.println(Arrays.toString(test.plusOne(in)));
    }
}