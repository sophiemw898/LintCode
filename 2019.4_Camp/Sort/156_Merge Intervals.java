/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        List<Interval> result = new ArrayList<>();
        
        //sort intervals by start Number
        Collections.sort(intervals,  new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        //compare end number one by one
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curt = intervals.get(i);
            if (last.end < curt.start) {
                result.add(last);
                last = curt;
            } else {
                last.end = Math.max(last.end, curt.end);
            }
        }
        //Don't forget the last interval
        result.add(last);
        return result;
    }
}
