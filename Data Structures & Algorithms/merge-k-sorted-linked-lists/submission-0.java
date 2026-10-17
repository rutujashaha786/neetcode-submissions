/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
 public class Pair implements Comparable<Pair>{
    ListNode node;

    public Pair(ListNode node){
        this.node = node;
    }

    public int compareTo(Pair o){
        return this.node.val - o.node.val;
    }
 }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        int n = lists.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            if(lists[i] != null){
                Pair p = new Pair(lists[i]);
                pq.add(p);
            }  
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            ListNode node = p.node;

            if(node.next != null){
                pq.add(new Pair(node.next));
            }

            prev.next = node;
            prev = node;
 
        }

        return dummyNode.next;

    }
}
