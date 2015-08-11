public class FindPeakElement {
    /**
    * A peak element is an element that is greater than its neighbors.
    * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
    * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
    * You may imagine that num[-1] = num[n] = -∞.
    * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
    */
    public int findPeakElement(int[] nums) {
        return findPeakOverRange (nums, 0, nums.length - 1, nums.length);
    }
    
    private int findPeakOverRange (int[] nums, int low, int high, int capacity) {
        /**
        * Recursively find peak in the range nums[low] to nums[high] using binary search
        */
        // to avoid overflow
        int mid = low + (high - low) / 2;
        // condition |low|high|low|
        if ((mid == 0 || nums[mid - 1] <= nums[mid]) && (mid == capacity - 1 || nums[mid + 1] <= nums[mid])) return mid;
        // search left half for a peak
        else if (mid > 0 && nums[mid - 1] > nums[mid]) return findPeakOverRange (nums, low, mid - 1, capacity);
        // search right half for a peak
        else return findPeakOverRange (nums, mid + 1, high, capacity);
    }
    
    public static void main (String[] args) {
        FindPeakElement test = new FindPeakElement ();
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {23, 21, 20, 21, 19, 17, 16};
        System.out.println (test.findPeakElement (nums1) == 2);
        System.out.println (test.findPeakElement (nums2) == 3);
    }
}