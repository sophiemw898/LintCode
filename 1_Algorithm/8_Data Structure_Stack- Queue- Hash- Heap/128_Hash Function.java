public class Solution {
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        int n = key.length;
        long res = 0;
        
        for (int i = 0; i < n; i++) {
            res = (res * 33 + (int)(key[i])) % HASH_SIZE;
        }
        
        return (int)res;
    }
}
