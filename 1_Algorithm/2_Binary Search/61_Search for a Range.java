public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return new int[] {-1, -1};
        }
        
        //find the first target in A
        int first_target = 0;
        int left = 0, right = A.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (A[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (A[left] != target && A[right] != target) {
            return new int[] {-1, -1};
        }

        first_target = (A[left] == target) ? left : right;

        //find the last target in A
        int last_target = 0;
        left = 0;
        right = A.length - 1;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (A[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        last_target = (A[right] == target) ? right : left;
        
        return new int[] {first_target, last_target};
    }
}
