//import java.util.Random;
public class RandomizedSet {
    
    private ArrayList<Integer> nums;
    private HashMap<Integer, Integer> nums2index;
    private Random rand;
    
    public RandomizedSet() {
        nums = new ArrayList<>();
        nums2index = new HashMap<>();
        rand = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if (nums2index.containsKey(val)) {
            return false;
        }
        
        nums2index.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        if (!nums2index.containsKey(val)) {
            return false;
        }
        
        int index = nums2index.get(val);
        if (index < nums.size() - 1) {
            //put last num in array to position index then delate last one to ensure O(1)
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            nums2index.put(last, index);
        }
        
        //delate last num
        nums.remove(nums.size() - 1);
        nums2index.remove(val);
        
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */
