class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null;}
}

public class PartitionLinkedList {
    /**
    * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
    * You should preserve the original relative order of the nodes in each of the two partitions. 
    */
    public ListNode partition(ListNode head, int x) {
        // no element or one element in list
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode (-1);
        dummyHead.next = head;
        ListNode current = head, prev = dummyHead, temp = null;
        ListNode greater = null, greaterT = null;
        ListNode[] greaterResult = new ListNode[2];
        while (current != null){
            if (current.val >= x) {
                temp = current;
                prev.next = current.next;
                current = current.next;
                greaterResult = appendNode (greater, greaterT, temp);    // make a list of all nodes with value >= x
                greater = greaterResult[0];    // adjust head of greater list
                greaterT = greaterResult[1];    //adjust tail of greater list
            } else {
                prev = current;
                current = current.next;
            }
        }
        // attach all nodes in greater list at the end of the original list
        prev.next = greater;
        return dummyHead.next;
    }
    
    private ListNode[] appendNode (ListNode head, ListNode tail, ListNode newNode) {
        /**
        * Append newNode at the end of the original list
        */
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = null;
        } else {
            tail.next = newNode;
            tail = tail.next;
            tail.next = null;
        }
        ListNode[] result = new ListNode[2];
        result[0] = head;
        result[1] = tail;
        return result;
    }
    
    public static void main (String[] args) {
        PartitionLinkedList test = new PartitionLinkedList ();
        ListNode head1 = new ListNode (1);
        head1.next = new ListNode (4);
        head1.next.next = new ListNode (3);
        head1.next.next.next = new ListNode (2);
        head1.next.next.next.next = new ListNode (5);
        head1.next.next.next.next.next = new ListNode (2);
        head1 = test.partition (head1, 3);
        StringBuilder result = new StringBuilder ();
        while (head1 != null) {
            result.append (head1.val + " ");
            head1 = head1.next;
        }
        System.out.println (result);
    }
}