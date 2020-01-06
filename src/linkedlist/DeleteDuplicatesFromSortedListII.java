/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class DeleteDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
 
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            // cur is not a duplicate
            // pre.next = cur
            if (pre.next == cur) {
                pre = pre.next;
            } 
            // cur is a duplicate 
            else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
