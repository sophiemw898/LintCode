public class Solution {
    /**
     * @param array: the input array
     * @return: the sorted array
     */
    class Element implements Comparable<Element> {
        int grade;
        int id;
        
        public Element(int grade, int id) {
            this.grade = grade;
            this.id = id;
        }
            
        public int compareTo(Element e) {
            if (grade == e.grade) {
                return id - e.id;
            }
            return e.grade - grade;
        }
    }     
    
    public int[][] multiSort(int[][] array) {
        // Write your code here
        //collections.sort() O(nlogn)
        List<Element> list = new ArrayList<>();
        for (int[] arr : array) {
            list.add(new Element(arr[1], arr[0]));
        }
        Collections.sort(list);
        
        int[][] result = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            Element element = list.get(i);
            result[i][0] = element.id;
            result[i][1] = element.grade;
        }
        
        return result;
        
        /*
        //selection sort O(n^2)
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (!compare(array[i], array[j])) {
                    // int temp = array[i][0];
                    // array[i][0] = array[j][0];
                    // array[j][0] = temp;
                    
                    // temp = array[i][1];
                    // array[i][1] = array[j][1];
                    // array[j][1] = temp;
                    int[] temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        
        return array;
        */
    }
    
    /*
    //use this method to check if both array need to change position
    private boolean compare(int[] a, int[] b) {
        if (a[1] > b[1]) {
            return true;
        }
        if (a[1] == b[1] && a[0] < b[0]) {
            return true;
        }
        
        return false;
    }
    */
}
