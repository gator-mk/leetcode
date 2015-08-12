import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null;}
}

public class LinkedListCycle2 {
    /**
    *  Given a linked list, return the node where the cycle begins. If there is no cycle, return null. 
    */
    public ListNode detectCycle(ListNode head) {
        // no elements or 1 element in list
        if (head == null || head.next == null) return null;
        ListNode current = head;
        ListNode cycleNode = null;
        HashSet<ListNode> nodeSet = new HashSet<>();
        while (current != null) {
            if (nodeSet.contains (current)) {
                cycleNode = current;
                break;
            }
            nodeSet.add (current);
            current = current.next;
        }
        return cycleNode;
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
        LinkedListCycle2 test = new LinkedListCycle2 ();
        ListNode head1 = new ListNode (2);
        test.append (head1, 4);
        test.append (head1, 5);
        test.append (head1, 9);
        head1.next.next.next.next = head1.next.next;
        System.out.println (test.detectCycle (head1).val == 5);
        ListNode head2 = null;
        System.out.println (test.detectCycle (head2) == null);
        ListNode head3 = new ListNode (19);
        System.out.println (test.detectCycle (head3) == null);
        ListNode head4 = new ListNode (0);
        test.append (head4, 16);
        test.append (head4, 15);
        test.append (head4, 7);
        System.out.println (test.detectCycle (head4) == null);
    }
}