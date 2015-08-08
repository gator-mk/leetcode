
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeLinkedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) { 
                ListNode[] result = append (head, tail, l1);
                head = result[0];
                tail = result[1];
                l1 = l1.next;
            } else {
                ListNode[] result = append (head, tail, l2);
                head = result[0];
                tail = result[1];
                l2 = l2.next;
            }
        }
        // if l2 == null
        if (l2 == null) head = (append (head, tail, l1))[0];
        // if l1 == null
        if (l1 == null) head = (append (head, tail, l2))[0];
        return head;
    }
    
    public ListNode[] append (ListNode head, ListNode tail, ListNode n) {
        if (head == null) {
            head = n;
            tail = n;
        }
        else {
            tail.next = n;
            tail = n;
        }
        ListNode[] nodeList = new ListNode[2];
        nodeList[0] = head;
        nodeList[1] = tail;
        return nodeList;
    }
    
    public static void main (String[] args) {
        MergeLinkedLists test = new MergeLinkedLists ();
        ListNode head1 = new ListNode (2);
        head1.next = new ListNode (5);
        head1.next.next = new ListNode (7);
        ListNode head2 = new ListNode (1);
        head2.next = new ListNode (4);
        head2.next.next = new ListNode (9);
        ListNode sortedHead = test.mergeTwoLists (head1, head2);
        StringBuilder result = new StringBuilder ();
        while (sortedHead != null) {
            result.append (sortedHead.val + " ");
            sortedHead = sortedHead.next;
        }
        System.out.println (result);
    }
}