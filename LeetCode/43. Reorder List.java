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
    public void reorderList(ListNode head) {
        ListNode temp = head;
        ListNode temp2 = head;
        while(temp2 != null && temp2.next != null){
            temp = temp.next;
            temp2 = temp2.next.next;
        }
        ListNode reverse = null;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = reverse;
            reverse = temp;
            temp = next;
        }
        ListNode ans = head;
        ListNode help = head.next;
        while(reverse != null || help != null){
            ans.next = reverse;
            if(reverse == null) break;
            reverse = reverse.next;
            ans = ans.next;
            ans.next = help;
            if(help == null) break;
            help = help.next;
            ans = ans.next;
        }
    }
}
