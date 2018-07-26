//用一个 last 来记录最后一个还没有被放到 merge results 里的 Interval，用于和新加入的 interval 比较看看能不能合并到一起。
//时间复杂度 O(n + m)

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
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> res = new ArrayList<>();
        if (list1 == null && list2 == null) {
            return res;
        }
        
        Interval last = null, curt = null;
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).start < list2.get(j).start) {
                curt = list1.get(i);
                i++;
            } else {
                curt = list2.get(j);
                j++;
            }
            
            last = merge(res, last, curt);
        }
        
        while (i < list1.size()) {
            curt = list1.get(i);
            i++;
            last = merge(res, last, curt);
        }
        while (j < list2.size()) {
            curt = list2.get(j);
            j++;
            last = merge(res, last, curt);
        }
        
        if (last != null) {
            res.add(last);
        }
        
        return res;
    }
    
    private Interval merge(List<Interval> res, Interval last, Interval curt) {
        if (last == null) {
            return curt;
        }
        if (last.end < curt.start) {
            res.add(last);
            last = curt;
            return last;
        }
        
        last.end = Math.max(last.end, curt.end);
        return last;
    }
}
