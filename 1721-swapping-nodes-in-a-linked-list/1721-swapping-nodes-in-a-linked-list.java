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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode slow = head;
        ListNode fast = head;
        int count = 1;
        
        int len = 0;
        while(slow != null){
            len++;
            slow = slow.next;
        }
        
        // System.out.println(len);
        
        // k = k / len
        
        if(k > len/2){
            
            k = Math.min(k, len-k+1);
            
        }
        
        // System.out.println(k);
        
        slow = head;
        while(count != k){
            fast = fast.next;
            count++;
        }
        
        ListNode toChange = fast;
        
        // System.out.println(fast.val);
        
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        int temp = slow.val;
        slow.val = toChange.val;
        toChange.val = temp;
        
        
        
        
        return head;
        
        
    }
}