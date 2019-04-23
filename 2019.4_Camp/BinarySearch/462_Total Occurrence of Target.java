public class Solution {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        //binarySearch 找第一个first 和最后一个last return last-first+ 1
        if (A == null || A.length == 0) {
            return 0;
        }
        //find the first target
        int first = 0;
        int last = 0;
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            first = start;
        } else if (A[end] == target) {
            first = end;
        } else {
            return 0;
        }
        //find last target
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            last = end;
        } else if (A[start] == target) {
            last = start;
        } else {
            return 0;
        }
        
        
        return last - first + 1;
    }
}
