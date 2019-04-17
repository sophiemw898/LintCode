public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // write your code here
        //选择排序 O(n^2)
        //双指针站肩; time O(n^2); for(int i = 0; i < array.length -1; i++) ==> 不需要走最后一位； for(int j = i + 1; j < array.length; j++)		
        
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    //用^  可以减少空间temp
                    // A[i] = A[i] ^ A[j];
                    // A[j] = A[i] ^ A[j];
                    // A[i] = A[i] ^ A[j];
                }
            }
        }
        
        //插入排序 O(n^2)
        //通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入							
        for (int i = 1; i < A.length; i++) {
            int newVal = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > newVal) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = newVal;
        }
        
        
        //冒泡排序 O(n^2)
        //大部分已排序时较好
        while (true) {
            boolean exchange = false;
            
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] > A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    exchange = true;
                }
            }
            
            if (!exchange) {
                break;
            }
        }
    }
}
