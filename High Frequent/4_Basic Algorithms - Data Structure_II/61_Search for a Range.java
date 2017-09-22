O(log n)
public class Solution {
    /*
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0 || target < A[0] || target > A[A.length - 1]) {
            return new int[] {-1, -1};
        }
        int[] ans = new int[2];
        //find the first position of target
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            ans[0] = start;
        } else if (A[end] == target) {
            ans[0] = end;
        } else {
            return new int[] {-1, -1};
        }
        
        //find the last position of target
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        //System.out.println(start);
        //System.out.println(end);
        
        if (A[end] == target) {
            ans[1] = end;
        } else if (A[start] == target) {
            ans[1] = start;
        } else {
            return new int[] {-1, -1};
        }
        return ans;
    }
}
