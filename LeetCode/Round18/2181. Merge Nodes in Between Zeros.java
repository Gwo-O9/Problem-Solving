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
    public ListNode mergeNodes(ListNode head) {
        ListNode node = new ListNode();
        ListNode ans = node;
        head = head.next;
        while(head!=null){
            int value = 0;
            while(true){
                value += head.val;
                head = head.next;
                if(head.val == 0){
                    node.next = new ListNode(value);
                    node = node.next;
                    head = head.next;
                    break;
                }
            }
        }
        return ans.next;
    }
}
