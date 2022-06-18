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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null) return head;
        
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            curr = curr.next;
            count++;
        }
        // System.out.println(count);
        // return null;
        
        k = k % count;
        if(k == 0) return head;
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i=0; i < k; i++){
            fast = fast.next;
        }
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
        
        
    }
}