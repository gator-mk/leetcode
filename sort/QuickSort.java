import java.util.*;
import java.lang.*;


public class QuickSort {
    /**
    * Quicksort the input subarray between low and high (inclusive)
    * Pivot element is chosen as the middle element
    */
    public static void quickSort (int[] A, int low, int high) {
        // Base case
        if (low == high) return;
        else {
            // Choose middle element as partition
            int partition_position = low + (high - low) / 2;
            // Partition array so that A[low to position - 1] <= pivot element 
            // and A[position + 1 to high] > pivot element
            int position = partition (A, partition_position, low, high);
            // Recursive calls to quickSort
            if (low < position) quickSort (A, low, position - 1);
            if (high > position) quickSort (A, position + 1, high);
        }
    }
    
    /**
    * Partition the subarray between low and high (inclusive) around the pivot element p
    * Return the position of the pivot element
    */
	public static int partition (int[] A, int p, int low, int high) {
        // if there are no elements in the subset
        if (low == high) return low;
		int less = low;
		int equal = low;
		int greater = high;
		int pivot = A[p];
        // equal == greater is a corner case
		while (equal <= greater) {
			if (A[equal] < pivot) swap (A, equal++, less++);
			else if (A[equal] == pivot) equal++;
			else swap (A, equal, greater--);
		}
        // return position of the last element equal to the value of pivot
		return equal - 1;
	}
	
    /**
    * Swap element at index1 with element at index2 in array A
    */
	private static void swap (int[] A, int index1, int index2) {
		if (index1 == index2) return;
		else {
			int temp = A[index1];
			A[index1] = A[index2];
			A[index2] = temp;
		}
	}
    
    /**
    * Validate that the input array is sorted
    */
    public static boolean validate (int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) return false;
        }
        return true;
    }
	
    /**
    * Compile with javac -source 1.4 QuickSort and run with java -ea QuickSort to enable asserts
    */
	public static void main (String[] args) throws java.lang.Exception {
        boolean validity = false;
		int[] A = {13, 4, 12, 12, 11, 1, 2, 3, 11, 0};
		quickSort (A, 0, A.length - 1);
        validity = validate (A);
        assert validity : "Array A was not sorted: " + Arrays.toString(A);
		System.out.println (Arrays.toString(A));
        int[] B = {11, 11, 11, 11, 11};
        quickSort (B, 0, B.length - 1);
        validity = validate (B);
        assert validity : "Array B was not sorted: " + Arrays.toString(B);
        System.out.println (Arrays.toString(B));
        int[] C = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
        quickSort (C, 0, C.length - 1);
        validity = validate(C);
        assert validity : "Array C was not sorted: " + Arrays.toString(C);
        System.out.println (Arrays.toString(C));
	}
}