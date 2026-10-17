class LRUCache {
    int cap;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        //initialise dummy DLL
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            delete(node);
            insertAtEndBeforeTail(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            delete(node);
            insertAtEndBeforeTail(node);
        }
        else{
            if(map.size() == cap){
                //remove LRU at front
                map.remove(head.next.key); //---1st delete, otherwise wrong key delete
                delete(head.next);
                
            }

            //add newnode at last
            Node newNode = new Node(key, value);
            insertAtEndBeforeTail(newNode);
            map.put(key, newNode);
        }


    }

    public void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAtEndBeforeTail(Node node){
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
     
}

public class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.value = val;
        this.prev = null;
        this.next = null;
    }
}
