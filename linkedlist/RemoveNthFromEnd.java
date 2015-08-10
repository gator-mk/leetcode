class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null;}
}

public class RemoveNthFromEnd {
    /**
    * Given a linked list, remove the nth node from the end of list and return its head. 
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nPrev = head;
        ListNode current = head;
        // to keep track of node previous to nth from the end
        int count = n + 1;
        // if no elements in list
        if (head == null) return null;
        // if n == 0, no node needs to be deleted
        if (n == 0) return head;
        while (current != null) {
            current = current.next;
            if (count == 0) nPrev = nPrev.next;
            else count--;
        }
        if (count == 0) nPrev.next = nPrev.next.next;
        // if the node is the head
        if (count == 1) head = head.next;
        return head;
    }
    
    public ListNode append (ListNode head, int val) {
        if (head == null) return new ListNode (val);
        ListNode cur = head;
        while (cur.next != null) cur = cur.next;
        ListNode newNode = new ListNode (val);
        cur.next = newNode;
        return head;
    }
    
    public String printList (ListNode head) {
        StringBuilder result = new StringBuilder ();
        while (head != null) {
            result.append (head.val + " ");
            head = head.next;
        }
        return result.toString();
    }
    
    public static void main (String[] args) {
        RemoveNthFromEnd test = new RemoveNthFromEnd ();
        ListNode head1 = new ListNode (1);
//         test.append (head1, 2);
//         test.append (head1, 3);
//         test.append (head1, 4);
//         test.append (head1, 5);
        head1 = test.removeNthFromEnd (head1, 1);
        System.out.println(test.printList (head1));
    }
}