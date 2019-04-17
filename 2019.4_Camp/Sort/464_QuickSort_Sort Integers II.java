public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        //quick sort O(nlogn) 
        if (A == null || A.length == 0) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        //define pivot
        int left = start, right = end;
        // key point 1: pivot is the value, not the index
        int pivot = A[start + (end - start) / 2];
        //move all number < pivot to right, move all number > pirot to right
        // key point 2: every time you compare left & right, it should be 
        // left <= right not left < right 因为最后递归的时候right < left
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        
        // System.out.println(left);
        // System.out.println(right);
        
        //right < end 
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
