//doubleLinkedList
public class LRUCache {

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.val = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    //get(key) Get the value of the key if the key exists in the cache, otherwise return -1.
    //HashMap after this. should move current node to tail, which means Recently Used 
        //1. remove current node //2. move current to tail
    public int get(int key) {
        if (!map.containsKey(key)) {
           return -1; 
        }
        Node curt = map.get(key);
        //1. remove current node
        curt.prev.next = curt.next;
        curt.next.prev = curt.prev;
        //2. move current to tail
        move2tail(curt);
        
        return curt.val;
    }

    public void set(int key, int value) {
        // get 这个方法会把key挪到最末端，因此，不需要再调用 move_to_tail
        // key is already present
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        // key is not already present. update map and Node
        //When the cache reached its capacity, remove head first and then set the currenrt 
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node insert = new Node(key, value);
        map.put(key, insert);
        move2tail(insert);
    }
    
    private void move2tail(Node n) {
        n.prev = tail.prev;
        tail.prev.next = n;
        tail.prev = n;
        n.next = tail;
    }
}
