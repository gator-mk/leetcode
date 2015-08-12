
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeLinkedLists {
    /**
    * Merge two sorted linked lists and return it as a new list. 
    * The new list should be made by splicing together the nodes of the first two lists.
    */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        // compare values of both nodes and merge
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
        // if l2 == null then merge remaining elements of l1
        if (l2 == null) head = (append (head, tail, l1))[0];
        // if l1 == null then merge remaining elemts of l2
        if (l1 == null) head = (append (head, tail, l2))[0];
        return head;
    }
    
    public ListNode[] append (ListNode head, ListNode tail, ListNode n) {
        /**
        * Given the head and tail of a linked list, append the new node and return new head and tail
        */
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