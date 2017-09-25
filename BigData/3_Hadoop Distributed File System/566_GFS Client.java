/* Definition of BaseGFSClient
 * class BaseGFSClient {
 *     private Map<String, String> chunk_list;
 *     public BaseGFSClient() {}
 *     public String readChunk(String filename, int chunkIndex) {
 *         // Read a chunk from GFS
 *     }
 *     public void writeChunk(String filename, int chunkIndex,
 *                            String content) {
 *         // Write a chunk to GFS
 *     }
 * }
 */


public class GFSClient extends BaseGFSClient {
    /*
    * @param chunkSize: An integer
    */
    private int chunkSize;
    private Map<String, Integer> chunkNum;
    public GFSClient(int chunkSize) {
        // do intialization if necessary
        this.chunkSize = chunkSize;
        this.chunkNum = new HashMap<>();
    }

    /*
     * @param filename: a file name
     * @return: conetent of the file given from GFS
     */
    public String read(String filename) {
        if (!chunkNum.containsKey(filename)) {
            return null;
        }
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < chunkNum.get(filename); i++) {
            if (readChunk(filename, i) != null) {
                content.append(readChunk(filename, i));
            }
        }
        System.out.println(content.toString());
        return content.toString();
        
    }

    /*
     * @param filename: a file name
     * @param content: a string
     * @return: nothing
     */
    public void write(String filename, String content) {
        int length = content.length();
        int num = (length - 1) / chunkSize + 1;
        chunkNum.put(filename, num);
        
        for (int i = 0; i < num; i++) {
            int start = i * chunkSize;
            int end = (i == num - 1) ? length : (i + 1) * chunkSize;
            writeChunk(filename, i, content.substring(start, end));
        }
    }
}
