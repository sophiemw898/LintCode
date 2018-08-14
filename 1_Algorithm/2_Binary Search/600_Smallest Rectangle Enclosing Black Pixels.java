public class Solution {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        
        //find the first/last row/col include 1 
        int left = findLeft(image, 0, y);
        int right = findRight(image, y, image[0].length - 1);
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, image.length - 1);
        
        return (right - left + 1) * (bottom - top + 1);
    }
    //find first col with not emply     isEmptyCol == false
    private int findLeft(char[][] image, int start, int end) {
        int left = start, right = end;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isEmptyCol(image, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return isEmptyCol(image, left) ? right : left;
    }
    //find last col with not emply
    private int findRight(char[][] image, int start, int end) {
        int left = start, right = end;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isEmptyCol(image, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        return isEmptyCol(image, right) ? left : right;
    }
    //find first row with 1
    private int findTop(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return isEmptyRow(image, start) ? end : start;
    }
    //find last row with 1
    private int findBottom(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return isEmptyRow(image, end) ? start : end;
    }
    
    private boolean isEmptyRow(char[][] image, int row) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[row][i] == '1') {
                return false;
            }
        }
        return true;
    }
    
    private boolean isEmptyCol(char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1') {
                return false;
            }
        }
        return true;
    }
}
