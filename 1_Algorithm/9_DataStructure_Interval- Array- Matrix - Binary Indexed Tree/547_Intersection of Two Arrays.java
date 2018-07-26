// version 1: sort and merge
//O(logn) + O(logm)
public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        int index = 0;
        int[] temp = new int[nums1.length];
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || temp[index - 1] != nums1[i]) {
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = temp[k];
        }
        
        return result;
    }
};

// version 2: hash map
//O（m+n） 需要额外空间
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        
        for (int i = 0; i < nums1.length; i++) {
            // if (!set.contains(nums1[i])) {
            //     set.add(nums1[i]);
            // }
            set.add(nums1[i]);
        }
        
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j]) && !resultSet.contains(nums2[j])) {
                resultSet.add(nums2[j]);
            }
        }
        
        int size = resultSet.size();
        int[] result = new int[size];
        int index = 0;
        
        for (int num : resultSet) {
            result[index++] = num;
        }
        return result;
    }
};

// version 3: sort & binary search
//O((m+n)logn)

public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resultSet = new HashSet<>();
        
        Arrays.sort(nums1);
        
        for (int i = 0; i < nums2.length; i++) {
            if (resultSet.contains(nums2[i])) {
                continue;
            }
            
            if (binarySearch(nums1, nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        
        int size = resultSet.size();
        int[] result = new int[size];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }
        
        return result;
    }
    
    //find if num was in nums1
    private boolean binarySearch(int[] nums1, int target) {
        if (nums1 == null || nums1.length == 0) {
            return false;
        }
        
        int start = 0, end = nums1.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums1[mid] == target) { 
                return true;
            } else if (nums1[mid] > target) {
                end = mid;
            } else{
                start = mid;
            }
        }
        
        if (nums1[start] == target) {
            return true;
        } 
        if (nums1[end] == target) {
            return true;
        }
        
        return false;
    }
};
