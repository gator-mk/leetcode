import java.util.HashMap;

public class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> occurrenceCountMap = new HashMap<>();
        for (int num : nums) {
            if (occurrenceCountMap.containsKey (num)) 
                return true;
            else 
                occurrenceCountMap.put (num, 1);
        }
        return false;
    }
    
    public static void main (String[] args) {
        ContainsDuplicates test = new ContainsDuplicates ();
        int[] testArray1 = {1, 2, 3, 4, 5};
        int[] testArray2 = {1, 1, 455};
        int[] testArray3 = {};
        System.out.println(test.containsDuplicate (testArray1));
        System.out.println(test.containsDuplicate (testArray2));
        System.out.println(test.containsDuplicate (testArray3));
    }
}