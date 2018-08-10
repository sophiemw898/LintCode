public class Solution {
    /**
     * @param num: An integer
     * @return: an integer array
     */
    public List<Integer> primeFactorization(int num) {
        List<Integer> results = new ArrayList<>();
        // O(1)  for (int i = 2; i <= num; i++)
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                num = num / i;
                results.add(i);
                System.out.println(num);
            }
        }
        
        if (num != 1) {
            results.add(num);
        }
        
        return results;
    }
}
