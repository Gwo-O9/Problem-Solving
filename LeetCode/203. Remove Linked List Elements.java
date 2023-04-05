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
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) head = head.next; //check whether the first some elements' value is val or not
        if(head == null) return head; //if head == null return head(null)
        ListNode temp = head;
        for(;temp.next != null;){ //remove node whose value is same with given val
            if(temp.next.val == val) temp.next = temp.next.next; //connect head node with next.next node
            else temp = temp.next; //else check next node
        }
        return head;
    }
}
