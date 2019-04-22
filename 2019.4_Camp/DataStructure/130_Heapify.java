public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        //i = (A.length - 2)/2最后一个叶节点的父亲的坐标
        for (int i = (A.length - 2)/2; i >= 0; i--) {
            siftDonw(A, i);
        }
    }
    
    //下移操作，变成堆
    private void siftDonw(int[] A, int k) {
        int n = A.length;
        while (k < n) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int minIndex = k;
            if (left < n && A[left] < A[minIndex]) {
                minIndex = left;
            }
            if (right < n && A[right] < A[minIndex]) {
                minIndex = right;
            }
            //父节点依然最小，保持不动已经成堆
            if (minIndex == k) {
                break;
            }
            
            //交换最小值与父节点
            int temp = A[minIndex];
            A[minIndex] = A[k];
            A[k] = temp;
            
            k = minIndex;
        }
    }
}
