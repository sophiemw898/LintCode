public class Solution {
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        //直接遍历key就可以了。char本身就是数字，不用强制类型转换。
        long res = 0;
        for (char c : key) {
            res = (33 * res + c) % HASH_SIZE;
            System.out.println(res);
        }
        //res 是long也不够，所以每个循环都要取余数
        //res = res % HASH_SIZE;
        return (int)res;
    }
}
