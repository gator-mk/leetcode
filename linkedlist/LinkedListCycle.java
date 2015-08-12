class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null;}
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // no elements
        if (head == null) return false;
        // one element
        if (head.next == null) return false;
        boolean result = false;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (fast.equals (slow)) {
                result = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return result;
    }
    
    public ListNode append (ListNode head, int val) {
        if (head == null) return new ListNode (val);
        ListNode cur = head;
        while (cur.next != null) cur = cur.next;
        ListNode newNode = new ListNode (val);
        cur.next = newNode;
        return head;
    }
    
    public static void main (String[] args) {
        LinkedListCycle test = new LinkedListCycle ();
        ListNode head1 = new ListNode (2);
        test.append (head1, 4);
        test.append (head1, 5);
        test.append (head1, 9);
        head1.next.next.next.next = head1.next.next;
        System.out.println (test.hasCycle (head1));
        ListNode head2 = null;
        System.out.println (test.hasCycle (head2));
        ListNode head3 = new ListNode (19);
        System.out.println (test.hasCycle (head3));
        ListNode head4 = new ListNode (0);
        test.append (head4, 16);
        test.append (head4, 15);
        test.append (head4, 7);
        System.out.println (test.hasCycle (head4));
    }
}