class Element {
    int row, col, val;
    public Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null) {
            return new int[0];
        }
        //Override
        int k = arrays.length;
        PriorityQueue<Element> pq = new PriorityQueue<>(k, new Comparator<Element>() {
            public int compare(Element e1, Element e2) {
                return e1.val - e2.val;
            }
        }
        );
        //update pq 
        int total_size = 0;
        for (int i = 0; i < k; i++) {
            if (arrays[i].length > 0) {
                total_size += arrays[i].length;
                pq.offer(new Element(i,0, arrays[i][0]));
            }
        }

        int[] res = new int[total_size];
        int index = 0;
        while (!pq.isEmpty()) {
            Element curt = pq.poll();
            res[index++] = curt.val;
            curt.col++;
            if (curt.col < arrays[curt.row].length) {
                curt.val = arrays[curt.row][curt.col];//Don't forget to update val!!!
                pq.offer(curt);
            }
        }
        
        return res;
    }
}
