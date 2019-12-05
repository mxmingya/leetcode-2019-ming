class LRUCache {
    // use LinkedList along HashMap, 
    // use HashMap to store because question require O(1) operation, 
    // use double LinkedList to maintain the LRU cache order.
    private class Node {
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // System.out.println(key);
        
        // store it to map, 
        if (!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        n.next.pre = n.pre;
        n.pre.next = n.next;
        moveToTail(n);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) { // use get instead of check map containsKey, because get calls moveToTail();
            map.get(key).val = value;
            return;
        }
        
        if ( map.keySet().size() == capacity) {
            
            Node n = map.get(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
            map.remove(n.key);
            
        }
        Node n = new Node(key, value);
        map.put(key, n);
        moveToTail(n);
    }
    
    private void moveToTail(Node n) {
        // System.out.println("mot");
        n.next = tail;
        tail.pre.next = n;
        n.pre = tail.pre;
        tail.pre = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
