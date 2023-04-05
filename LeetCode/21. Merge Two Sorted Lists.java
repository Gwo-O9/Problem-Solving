
 //Definition for singly-linked list.
 public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }



class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null) return null;
        else if(list1 == null) return list2;
        else if(list2 == null) return list1;
        
        ListNode realoutput = new ListNode();
        ListNode output = realoutput;
        
        while(list1 != null && list2 != null){
            if(list2.val > list1.val) {
                output.next = list1;
                output = output.next;
                list1 = list1.next;
            }
            else{
                output.next = list2;
                output = output.next;
                list2 = list2.next;
            }
        }
        
        while(list1 != null){
            output.next = list1;
            output = output.next;
            list1 = list1.next;
        }
        while(list2 != null){
            output.next = list2;
            output = output.next;
            list2 = list2.next;
        }
        return realoutput.next;
    }
}
