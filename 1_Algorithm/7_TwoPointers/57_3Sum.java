Hash    O(n^2) O(n)
2Points O(n^2) O(1)
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        
        Arrays.sort(numbers);
        
        for (int i = 0; i < numbers.length; i++) {
            // skip duplicate triples with the same first numebr
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            
            int target = -numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            twoSum(numbers, left, right, target, result);
        }
        
        return result;
    }
    
    private void twoSum(int[] numbers, int left, int right, int target, List<List<Integer>> result) {
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                ArrayList<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(numbers[left]);
                triple.add(numbers[right]);
                result.add(triple);
                
                left++;
                right--;
                
                // skip duplicate pairs with the same left
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                // skip duplicate pairs with the same right
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}
