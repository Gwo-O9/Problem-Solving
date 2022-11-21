/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/* Solution 1*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        
        while(curA != null){
            curB = headB;
            while(curB != null){
                if(curB == curA) return curB;
                curB = curB.next;
            }
            curA=curA.next;
        }
        return null;
    }
}

/* Solution 2 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        HashSet<ListNode> map = new HashSet<>();
        if(curA == null || curB == null) return null;
        
        for(;curB != null;curB = curB.next){
            map.add(curB);
        }
        for(;curA != null;curA = curA.next){
            if(!map.add(curA)){
                return curA;
            }
        }
        return null;
    }
}
