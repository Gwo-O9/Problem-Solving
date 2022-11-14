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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        int i = 0;
        while(cur != null){
            if(cur.next == null) break;
            if(cur.val == cur.next.val){
                if(cur.next.next == null){
                    cur.next = null;
                    return head;
                }
                else{
                cur.next = cur.next.next;
                }
            }
            else{
                cur = cur.next;
            }
        }
        return head;
    }
}
