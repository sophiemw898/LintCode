//烙饼排序，只能做翻转操作，第一次遍历n长度数组，每次遍历到的数和首位比较，比首位大的话，翻转，这样使得第一位是最大数字，循环结束翻转数组，这样最大数就位
接下来的循环则是对n-1长度部分找到最大值，使得最大值就位，以此类推

/**
 * public class FlipTool {
 *   static public void flip(int[] arr, int i) {
 *      ...
 *   }
 * }
 */
public class Solution {
    /**
     * @param array: an integer array
     * @return: nothing
     */
    public void pancakeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        
        int n = array.length;
        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                if (array[0] < array[i + 1]) {
                    FlipTool.flip(array, i + 1);
                }
            }
            //For here, A[0] is the max mun
            
            FlipTool.flip(array, n - 1);
            //Move max A[0] to the last Number
            n--;
        }
    }
}



//****************************************************
/**
 * public class FlipTool {
 *   static public void flip(int[] arr, int i) {
 *      ...
 *   }
 * }
 */
public class Solution {
    /**
     * @param array: an integer array
     * @return: nothing
     */
    public void pancakeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        
        for (int i = array.length - 1; i >= 0; i--) {
            maxArrayLast(array, i);
            System.out.println(array[i]);
        }
    }
    
    //通过每次翻转,检查A[0]找到最大值，然后update最后一位
    private void maxArrayLast(int[] array, int last) {
        int max = array[0];
        for (int i = 0; i <= last; i++) {
            FlipTool.flip(array, i);
            max = Math.max(max, array[0]);
        }
        
        //find the index of max
        int index = 0;
        for (int i = 0; i <= last; i++) {
            if (array[i] == max) {
                index = i;
            }
        }
        
        array[index] = array[last];
        array[last] = max;
    }
}
