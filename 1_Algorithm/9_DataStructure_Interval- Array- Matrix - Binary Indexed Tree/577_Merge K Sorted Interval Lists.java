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
// 1. transfer all lists in one with incearing start 
// 2. merge intevals
class Pair {
    int row;
    int col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class Solution {
    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        
        int k = intervals.size();
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>() {
        public int compare(Pair p1, Pair p2) {
            return intervals.get(p1.row).get(p1.col).start 
                    - intervals.get(p2.row).get(p2.col).start;
        }
    });
    
    for (int i = 0; i < k; i++) {
        if (intervals.get(i).size() > 0) {
            pq.offer(new Pair(i, 0));
        }
        //pq.offer(new Pair(i, 0));
    }
    
    while (!pq.isEmpty()) {
        Pair curt = pq.poll();
        res.add(intervals.get(curt.row).get(curt.col));
        curt.col++;
        if (curt.col < intervals.get(curt.row).size()) {
            pq.offer(curt);
        }
    }
    
    return merge(res);
    }
    
    private List<Interval> merge(List<Interval> res) {
        if (res.size() <= 1) {
            return res;
        }
        Interval past = null;
        List<Interval> result = new ArrayList<>();
        for (Interval curt : res) {
            if (past == null || past.end < curt.start) {
                result.add(curt);
                past = curt;
            } else {
                past.end = Math.max(past.end, curt.end);
            }
        }
        
        return result;
    }
}
