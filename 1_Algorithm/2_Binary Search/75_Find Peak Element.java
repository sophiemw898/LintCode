public class Solution {
    /*
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        //四种情况：下降区间end = mid；上升区间start = mid；峰值return mid；最低峰值均可
        //合并成三种情况
        //第一个和最后一个值一定不是峰值
        int start = 1;
        int end = A.length - 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid - 1]) {
                end = mid;
            } else if (A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                return mid;
            }
        }
        return A[start] > A[end] ? start : end;
    }
}
O(log n)
