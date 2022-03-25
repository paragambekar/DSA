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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1 == null) return list2;
        
        if(list2 == null) return list1;
        
        ListNode curr;
        ListNode t1;
        ListNode t2;
        ListNode head;
        if(list1.val <= list2.val){
            curr = list1;
            t1 = list1.next;
            t2 = list2;
            head = curr;
        }else{
            curr = list2;
            t2 = list2.next;
            t1 = list1;
            head = curr;
        }
        
        while(t1 != null && t2 != null){
            
            if(t1.val > t2.val){
                curr.next = t2;
                curr = curr.next;
                t2 = t2.next;
            }else{
                curr.next = t1;
                curr = curr.next;
                t1 = t1.next;
            }
            
        }
        
        if(t1 == null){
            curr.next  = t2;
        }else if(t2 == null){
            curr.next = t1;
        }
        
        return head;
        
    }
}