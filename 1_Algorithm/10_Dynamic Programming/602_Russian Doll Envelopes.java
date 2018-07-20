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
