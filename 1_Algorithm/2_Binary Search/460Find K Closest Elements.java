O(logn + k) time complexity.

public class Solution {
    /*
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length == 0) {
            return A;
        }
        
        int left = findLowerClosest(A, target);
        int right = left + 1;
        int[] result = new int[k];
        
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(A, target, left, right)) {
                result[i] = A[left];
                left--;
            } else {
                result[i] = A[right];
                right++;
            }
        }
        
        return result;
    }
    
    //find the closest number < target
    private int findLowerClosest(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (A[end] < target) {
           return end;
        }
        if (A[start] < target) {
            return start;
        }
    
        return -1;//no number < target, target is minimum, right++
    }
    
    //check if the left number is closer
    private boolean isLeftCloser(int[] A, int target, int left, int right) {
        //target is minimun
        if (left == -1) {
            return false;
        }
        //target is maximun, left = A.length
        if (right >= A.length) {
            return true;
        }
        if (target - A[left] != A[right] - target) {
            return target - A[left] < A[right] - target;
        }
        return true;
    }
}
