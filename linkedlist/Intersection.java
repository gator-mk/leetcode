class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null;}
}

public class Intersection {
    /**
    * Find the node at which the intersection of two singly linked lists begins.
    * If the two linked lists have no intersection at all, return null.
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode result = null;
        int lenA, lenB, diff;
        lenA = getLength (headA);
        lenB = getLength (headB);
        // advance head of longer list till both lists are of same length
        if (lenA > lenB) {
            diff = lenA - lenB;
            headA = shiftHead (headA, diff);
        }
        else if (lenB > lenA) {
            diff = lenB - lenA;
            headB = shiftHead (headB, diff);
        }
        // compare till intersecting node is found
        while (headA != null && headB != null) {
            if (headA.equals(headB)) {
                result = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return result;
    }
    
    public ListNode shiftHead (ListNode head, int n) {
        /**
        * Advance pointer to head by n and return new head
        */
        while (n != 0 && head != null) {
            head = head.next;
            n--;
        }
        return head;
    }
    
    public int getLength (ListNode head) {
        /**
        * Find and return the length of list
        */
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
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
        Intersection test = new Intersection ();
        ListNode head1 = new ListNode (2);
        test.append (head1, 4);
        test.append (head1, 6);
        ListNode intersectionNode = test.append (head1, 8);
        test.append (head1, 16);
        test.append (head1, 32);
        test.append (head1, 64);
        ListNode head2 = new ListNode (10);
        head2.next = intersectionNode;
        System.out.println (intersectionNode.equals(test.getIntersectionNode (head1, head2)));
    }
}