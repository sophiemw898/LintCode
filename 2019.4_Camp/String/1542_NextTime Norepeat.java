public class Solution {
    /**
     * @param time: 
     * @return: return a string represents time
     */
    public String nextTime(String time) {
        // write your code here
        if (time.length() != 5 || time == null) {
            return "-1";
        }
        String ans = "";
        String[] temp = time.split(":");
        int hour = Integer.parseInt(temp[0]);
        int min = Integer.parseInt(temp[1]);
        //check validation
        if (hour >= 24 || min >= 60) {
            return "-1";
        }
        int nowTime = hour * 60 + min;
        //处理nextTime
        int[] digits = new int[] {600, 60, 10, 1};
        for (int i = 1; i <= 1440; i++) {
            int nextTime = (nowTime + i) % 1440;
            ans = "";
            for (int j = 0; j < 4; j++) {
                ans += Integer.toString(nextTime / digits[j]);
                nextTime = nextTime % digits[j];
            }
            if (isValid(ans)) {
                break;
            }
        }
        
        return ans.substring(0,2) + ":" + ans.substring(2);
        
    }
    
    private boolean isValid(String str) {
        if (str.length() == 0) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for(char ch : str.toCharArray()) {
            set.add(ch);
        }
        if (set.size() == str.length()) {
            return true;
        }
        
        return false;
    }
}
