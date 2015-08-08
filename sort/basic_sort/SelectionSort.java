import java.util.Arrays;
    
public class SelectionSort {
    private static boolean less (Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }
    
    private static void exch (Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    public static void sort (Comparable[] a) {
        for (int i = 0; i < a.length; i++){
            int smallest = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less (a[j], a[smallest]))
                    smallest = j;
            }
            if (i != smallest)
                exch (a, i, smallest);
        }
    }
    
    public static void main (String[] args) {
        Integer[] unorderedArray = {432, 1, 0, 326, 899, 1000, 20};
        SelectionSort.sort (unorderedArray);
        System.out.println (Arrays.toString(unorderedArray));
    }
}