class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    private HashMap<Integer, Node> cache; // Maps key → Node in linked list
    private Node left;  // Dummy head (MRU side - most recently used)
    private Node right; // Dummy tail (LRU side - least recently used)
    private int cap;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.cap = capacity;

        // Create dummy nodes to simplify edge cases
        // Structure: left (MRU) ←→ ... ←→ right (LRU)
        this.left = new Node(0, 0);
        this.right = new Node(0, 0); 
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    // Helper: Remove node from its current position in linked list
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Insert node at the MRU position (right after 'left' dummy)
    private void insert(Node node){
        Node previousMRU = this.left.next;
        
        this.left.next = node;
        node.prev = this.left;
        node.next = previousMRU;
        previousMRU.prev = node;
    }

    public int get(int key) { // O(1)
        if(!cache.containsKey(key)){
            return -1;
        }
        
        Node node = cache.get(key);
        
        // Mark as recently used by moving to MRU position
        remove(node);  // Remove from current position
        insert(node);  // Insert at MRU position (after left)
        
        return node.val;
    }
    
    public void put(int key, int value) { // O(1)
        // If key exists, remove old node from linked list
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        
        // Create a new node and add to cache HashMap
        Node newNode = new Node(key, value);
        cache.put(key, newNode);

        // Insert into linked list at most recent used position (after left)
        insert(newNode);
        
        // Evict LRU if over capacity
        if(cache.size() > cap){
            Node lru = this.right.prev; // LRU is right before right dummy
            remove(lru);
            cache.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 /* 

- HashMap (cache)
Key: integer
Value: reference/pointer to a Node
Purpose: O(1) lookup


- Doubly Linked List (left ↔ nodes ↔ right)
Nodes connected with prev and next pointers
Purpose: O(1) insertion/removal and maintain order


time: O(1) for get() and put()
space: O(n) hashmap
 */
