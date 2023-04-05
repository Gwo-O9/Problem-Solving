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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int len1 = 0;
        int len2 = 0;
        while(temp1.next != null){
            len1++;
            temp1 = temp1.next;
        }
        while(temp2.next != null){
            len2++;
            temp2 = temp2.next;
        }
        ListNode ans = len1 > len2 ? l1 : l2;
        ListNode rans = ans;
        int roundup = 0;
        ListNode save = new ListNode();
        while(l1 != null && l2 != null){
            ans.val = l1.val + l2.val + roundup;
            if(roundup == 1) roundup--;
            if(ans.val >= 10) {
                ans.val = ans.val - 10;
                roundup = 1;
            }
            save = ans;
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null) {
            while(l2 != null){
                //ans = new ListNode();
                ans.val = l2.val + roundup;
                if(roundup == 1) roundup--;
                if(ans.val >= 10){
                    ans.val = ans.val - 10;
                    roundup++;
                }
                save = ans;
                ans = ans.next;
                l2 = l2.next;
            }
        }
        else if(l2 == null) {
            while(l1 != null){
                //ans = new ListNode();
                ans.val = l1.val + roundup;
                if(roundup == 1) roundup--;
                if(ans.val >= 10) {
                    ans.val = ans.val - 10;
                    roundup++;
                }
                save = ans;
                ans = ans.next;
                l1 = l1.next;
            }
        }
        if(roundup > 0) {
            ListNode tmp = new ListNode(1);
            save.next = tmp;
        }
        return rans;
    }
}
