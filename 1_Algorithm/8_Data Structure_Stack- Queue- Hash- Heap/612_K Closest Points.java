基于 PriorityQueue 的方法
PriorityQueue 里从远到近排序。当 PQ 里超过 k 个的时候，就 pop 掉一个。
时间复杂度 O(nlogk)O(nlogk)

public class Solution {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    //private Point global_origin = null;
    
    public Point[] kClosest(Point[] points, Point origin, int k) {
        //global_origin = origin;
        Point[] res = new Point[k];
        //1.写一个最大堆
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point> () {
            @Override
            public int compare(Point A, Point B) {
                int diff = getDist(B, origin) - getDist(A, origin);
                if (diff == 0) {
                    diff = B.x - A.x;
                }
                if (diff == 0) {
                    diff = B.y - A.y;
                }
                
                return diff;
            }
        }
        );
        
        //2. 遍历points的同时，维持pq的size为k，将大的弹出，最后pq中为最小的k个
        for (Point p : points) {
            pq.add(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        //3. 弹出pq中点，从大到小写入res[]
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        
        return res;
    }
    
    private int getDist(Point a, Point b) {
        return (int)(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
        //return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
        //return (a.x - b.x) ^ 2 + (a.y - b.y) ^ 2; java 里^表示位与 应该用Math.pow（） 默认float
    }
}
