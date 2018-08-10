//Memory Limit Exceeded including answer giver byjz
public class Solution {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
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
            return 0;
        }
        // System.out.println(left);
        // System.out.println(right);
        first_target = (A[left] == target) ? left : right;
        
        // if (A[left] == target) {
        //     first_target = left;
        // }
        // if (A[right] == target) {
        //     first_target = right;
        // }
        //此时可能left right同时为target 所以应该用if else而不是两个if
        System.out.println(first_target);
        
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
        System.out.println(last_target);
        
        return last_target - first_target + 1;
    }
}
