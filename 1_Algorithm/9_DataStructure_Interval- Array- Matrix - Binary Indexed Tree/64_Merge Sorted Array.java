class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m-1, j = n-1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        while (i >= 0) {
            A[index--] = A[i--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }
}

public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        //从小往大排序 O（m * n）
        //从大往小排序 O（m+n）
        int index = m + n - 1;
        
        while (m > 0 && n > 0) {
            if (B[n - 1] > A[m - 1]) {
                A[index] = B[n - 1];
                n--;
            } else {
                A[index] =  A[m - 1];
                m--;
            }
            index--;
        }
        
        while (n > 0) {
            A[index] = B[n - 1];
            index--;
            n--;
        }
        while (m > 0) {
            A[index] = A[m - 1];
            index--;
            m--;
        }
    }
}
