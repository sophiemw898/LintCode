public class Solution {
    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        //Algorithm
        //Get the index that ArrayReader.get(k) >= target in O(log k)
        //Binary search the target between 0 and index;
        int index = 1;
        while (reader.get(index - 1) < target) {
            index *= 2;
        }
        
        int start = 0; 
        int end = index - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                end = mid;
            } else if (reader.get(mid) > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}
O(log k)
