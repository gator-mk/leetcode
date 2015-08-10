import java.util.Arrays;

public class DutchFlag {
    public void sortColors(int[] nums) {
        // colors represented by 0, 1, and 2
        int pivot = 1;
        int smaller = 0, equal = 0, larger = nums.length - 1;
        while (equal <= larger) {
            if (nums[equal] < pivot) swap (equal++, smaller++, nums);
            else if (nums[equal] == pivot) equal++;
            else swap (equal, larger--, nums);
        }
    }
    
    private void swap (int index1, int index2, int[] nums) {
        if (index1 > nums.length - 1 || index2 > nums.length - 1 || 
        index1 < 0 || index2 < 0) return;
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    
    public static void main (String[] args) {
        DutchFlag test = new DutchFlag ();
        int[] colorList = {1, 2, 2, 2, 1, 0, 0, 1, 0, 0, 2, 0, 0};
        int[] test1 = {0, 0};
        test.sortColors (colorList);
        test.sortColors (test1);
        System.out.println (Arrays.toString (colorList));
        System.out.println (Arrays.toString (test1));
    }
}