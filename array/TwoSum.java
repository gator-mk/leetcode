import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (diffMap.containsKey (target - nums[i])) {
                result[0] = diffMap.get (target - nums[i]);
                result[1] = i + 1;
            }
            diffMap.put(nums[i], i + 1);
        }       
        return result;
    }
    
    public static void main (String[] args) {
        TwoSum test = new TwoSum();
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] nums2 = {0, 1, 4, 0};
        System.out.println(Arrays.toString (test.twoSum (nums1, 21)));
        System.out.println(Arrays.toString (test.twoSum (nums2, 0)));
    }
}