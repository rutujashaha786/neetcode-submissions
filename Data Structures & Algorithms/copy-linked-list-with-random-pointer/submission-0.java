/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //Create a copy of every NODE (just values) & update HashMap for mapping
        HashMap<Node, Node> map = new HashMap<>();

        Node current = head;
        while(current != null){
            Node newNode = new Node(current.val);
            map.put(current, newNode);
            current = current.next;
        }

        //update next, random pointers of new node
        current = head;
        while(current != null){
            Node cloned = map.get(current);
            cloned.next = map.get(current.next);
            cloned.random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);

    }
}
