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
        if(head == null){
            return null;
        }
        //Create adjacent mapping LL - A-A'-B-B' - insert operation

        Node current = head;
        while(current != null){
            Node newNode = new Node(current.val);
            Node next = current.next; //preserve next

            current.next = newNode;
            newNode.next = next;
            current = next;
        }

        //Update random pointers for new nodes
        current = head;
        while(current != null){
            Node cloned = current.next;
            if(current.random != null){
                cloned.random = current.random.next;
            }
            current = cloned.next;
        }

        //separate both 
        Node clonedHead = head.next;

        Node current1 = head;
        Node current2 = head.next;
        while(current2.next != null){
            current1.next = current1.next.next;
            current2.next = current2.next.next;

            //how to advance pointers
            current1= current1.next;
            current2= current2.next;
        }

        current1.next = null;
        current2.next = null;

        return clonedHead;
    }
}
