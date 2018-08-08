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
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        int k = intervals.size();
        //sort based on start
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        Interval last = intervals.get(0);
        for (int i = 1; i < k; i++) {
            Interval curt = intervals.get(i);
            if (last.end < curt.start) {
                res.add(last);
                last = curt;
            } else {
                last.end = Math.max(last.end, curt.end);
            }
        }
        
        res.add(last);
        return res;
    }
}
