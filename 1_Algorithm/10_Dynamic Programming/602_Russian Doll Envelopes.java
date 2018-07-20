//O(Nlogn) 没自己写

public class Solution {
    /*
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] e1, int[] e2) {
                int diff = e1[0] - e2[0];
                if (diff == 0){
                    diff = e2[1] - e1[1];
                }
                return diff;
            }
        });
        int[][] temp = new int[envelopes.length + 1][2];
        temp[0][0] = Integer.MIN_VALUE;
        temp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < temp.length; i++){
            temp[i][0] = Integer.MAX_VALUE;
            temp[i][1] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < envelopes.length; i++){
            int index = search(envelopes[i], temp);
            temp[index] = envelopes[i];
        }
        for (int j = temp.length - 1; j >= 0; j--){
            if (temp[j][0] != Integer.MAX_VALUE && temp[j][1] != Integer.MAX_VALUE){
                return j;
            }
        }
        return 1;
    }
    private int search(int[] env, int[][] temp) {
        int start = 0;
        int end = temp.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (!isVal(env, temp[mid])){
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;
    }
    private boolean isVal(int[] env1, int[] env2) {
        return env1[0] > env2[0] && env1[1] > env2[1];
    }
}

//o(n^2) 超时
public class Solution {
    /*
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        //状态：设f[i]表示以Ei为最外层信封时最多的嵌套层数
        //f[i] = max{1, f[j]+1| Ej 能放在Ei里}
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        int[] f = new int[envelopes.length];
        
        //先排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2){
                if (arr1[0] == arr2[0]) {
                    return arr1[1] - arr2[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        
        int max = 0;
        for (int i = 0; i < envelopes.length; i++) {
            //case 1
            f[i] = 1;
            //case 2
            //enumelate second outmost envelope
            for (int j = 0; j < i; j++) {
                //both length and width are smaller
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            max = Math.max(max, f[i]);
        }
        
        return max;
    }
}
