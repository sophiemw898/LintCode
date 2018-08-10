public class Solution {
    /**
     * @param n: An integer
     * @return: The sum of a and b
     */
    public int dropEggs(int n) {
        long ans = 0;//n 取int最大值 ans越界
        for (int i = 1; ; i++) {
            ans += (long)i;
            if (ans >= (long)n) {
                return i;
            }
        }
    }
}
