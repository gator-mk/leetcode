import java.util.HashMap;

public class MajorityElement {
    /**
    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
    You may assume that the array is non-empty and the majority element always exist in the array.
    */
    public int majorityElement(int[] nums) {
        int majority = 0;
        HashMap<Integer, Integer> freq = new HashMap<> ();
        for (int num : nums) {
            int count = freq.containsKey(num) ? freq.get(num) : 0;
            if (count + 1 > nums.length / 2) {
                majority = num; 
                break;
            }
            freq.put (num, count + 1);
        }
        return majority;
    }
    
    public static void main (String[] args) {
        MajorityElement test = new MajorityElement ();
        int[] nums = {12, 13, 12, 1, 12, 12, 12, 14, 12, 15, 12, 12};
        System.out.println (test.majorityElement (nums));
    }
}