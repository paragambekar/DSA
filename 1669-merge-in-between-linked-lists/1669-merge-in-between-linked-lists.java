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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode back = list1;
        ListNode front = list1;
        int counta = 0;
        int countb = 0;
        while(counta != a-1){
            back = back.next;
            counta++;
        }
        
        while(countb != b+1){
            front = front.next;
            countb++;
        }
        
        back.next = list2;
        
        ListNode curr = list2;
        
        while(curr.next != null){
            curr = curr.next;
        }
        
        curr.next = front;
        
        
        return list1;
        
        
        
    }
}