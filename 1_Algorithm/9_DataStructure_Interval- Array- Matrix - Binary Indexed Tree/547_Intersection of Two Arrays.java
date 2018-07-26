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
