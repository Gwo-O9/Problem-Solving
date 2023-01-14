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
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        ListNode temp2 = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }    
        int[] arr = new int[cnt];
        int i, j;
        for(i = 0; i< cnt;i++){
            arr[i] = temp2.val;
            temp2 = temp2.next;
        }
        for(i = 0, j = cnt-1; i< cnt;i++, j--){
            if(arr[i] != arr[j]) return false;
        }
        return true;
    }
}
