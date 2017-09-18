/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf destination buffer
     * @param n maximum number of characters to read
     * @return the number of characters read
     */
    char[] buffer = new char[4];
    int head = 0;
    int tail = 0;
    
    public int read(char[] buf, int n) {
        // Write your code here
        int i = 0;
        while (i < n) {
            if (head == tail) {      //queue is empty
                head = 0;
                tail = read4(buffer);   //enqueue
                if (tail == 0) {
                    break;
                }
            }
            if (head < tail && i < n) {
                buf[i++] = buffer[head++];  //dequeue
            }
        }
        return i;
    }
}

/*input 
"filetestbuffer"
read(6)
read(5)
read(4)
read(3)
read(2)
read(1)
read(10)

output
6, buf = "filete"
5, buf = "stbuf"
3, buf = "fer"
0, buf = ""
0, buf = ""
0, buf = ""
0, buf = ""
*/
