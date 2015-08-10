import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int n : nums) {
            if (n != val) 
                nums[index++] = n;
        }
        return index;
    }
    
    public static void main (String[] args) {
        RemoveElement test = new RemoveElement ();
        int[] nums1 = {1, 2, 1, 1, 3, 4};
        System.out.println (test.removeElement(nums1, 1));
        System.out.println (Arrays.toString (nums1));
    }
}