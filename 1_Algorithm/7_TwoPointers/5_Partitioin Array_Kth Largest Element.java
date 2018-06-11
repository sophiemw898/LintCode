O(n) time, O(1) extra memory.

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        return quickSelect(nums, start, end, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        int i = start, j = end;
        int pivot = nums[(i + j) / 2];
        
        while (i <= j ) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                i++;
                j--;
            }
        }
            
        if (start + k - 1 <= j) {
            return quickSelect(nums, start, j, k);
        }
        
        if (start + k - 1 >= i) {
            return quickSelect(nums, i, end, k - (i - start));
        }
            
            return nums[j + 1];
    }
};


