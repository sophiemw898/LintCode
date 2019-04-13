public class Solution {
    /**
     * @param array: the input array
     * @return: the sorted array
     */
    public int[][] multiSort(int[][] array) {
        // Write your code here
        //bubble sort
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (!compare(array[i], array[j])) {
                    int temp = array[i][0];
                    array[i][0] = array[j][0];
                    array[j][0] = temp;
                    
                    temp = array[i][1];
                    array[i][1] = array[j][1];
                    array[j][1] = temp;
                }
            }
        }
        
        return array;
    }
    
    //use this method to check if both array need to change position
    private boolean compare(int[] a, int[] b) {
        if (a[1] > b[1]) {
            return true;
        }
        if (a[1] == b[1] && a[0] < b[0]) {
            return true;
        }
        
        return false;
    }
}
