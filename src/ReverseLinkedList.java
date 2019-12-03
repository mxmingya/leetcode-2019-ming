class ReverseLinkedList {
    class ListNode {
        ListNode next;
        int val;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    ListNode pre = null;
    public ListNode reverseLinkedList(ListNode head) {
        if (head == null) {
            return head;
        }
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head.next;
    }
}
