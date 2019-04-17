public class Solution {
    /**
     * @param houses: positions of houses
     * @param heaters: positions of heaters
     * @return: the minimum radius standard of heaters
     */
    public int findRadius(int[] houses, int[] heaters) {
        // Write your code here
        //对于每个房屋i，在加热器数组里使用二分查找找到距离房屋i最近的加热器的位置，最后的答案为所有房屋答案的最大值。
        Arrays.sort(heaters);
        int radius = 0;
        
        for (int house : houses) {
            int temp = dist(heaters, house);
            //System.out.println(temp);
            radius = Math.max(radius, temp);
        }
        
        return radius;
    }
    
    //返回距离最近的点的距离
    //先找第一个大于目标值的点
    private int dist(int[] heaters, int target) {
        if (heaters.length == 1) {
            return Math.abs(target - heaters[0]);
        }
        
        int left = 0, right = heaters.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        //corner case 若target比最小值还小，则直接返回，否则left=0，left-1无意义
        if (target < heaters[0]) {
            return Math.abs(target - heaters[0]);
        }
        
        if (heaters[left] > target) {
            return Math.min(heaters[left] - target, target - heaters[left - 1]);
        }

        if (heaters[right] > target) {
            return Math.min(heaters[right] - target, target - heaters[right - 1]);
        }
        
        return -1;
    }
}
