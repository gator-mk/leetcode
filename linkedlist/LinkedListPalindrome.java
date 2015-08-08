public class LinkedListPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode prevToSlow = null;
        ListNode fast = head;
        ListNode mid = null;
        boolean result = true;
        if (head != null && head.next != null) {
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                prevToSlow = slow;
                slow = slow.next;
            }
            // fast is null when list has even number of elements
            if (fast != null) {
                mid = slow;
                slow = slow.next;
            }
            // terminate first half with a null
            prevToSlow.next = null;
            // reverse seconf half
            ListNode revSecondHalf = reverse (slow);
            // compare first half with second half
            result = isEqual (head, revSecondHalf);
            // reconstruct original linked list
            ListNode secondHalf = reverse (revSecondHalf);
            // if odd number of elements, reattach mid
            if (mid != null) {
                prevToSlow.next = mid;
                mid.next = secondHalf;
            }
        }
        return result;
    }
    
    public ListNode reverse (ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode rest = head.next;
        head.next = null;
        ListNode rev = reverse (rest);
        rest.next = head;
        return rev;
    }
    
    public boolean isEqual (ListNode list1, ListNode list2) {
        boolean result = true;
        while (list1 != null && list2 != null && result != false) {
            if (list1.val != list2.val) result = false;
            list1 = list1.next;
            list2 = list2.next;
        }
        return (list1 == null && list2 == null && result == true);
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
        LinkedListPalindrome test = new LinkedListPalindrome();
        ListNode head1 = new ListNode (2);
        test.append (head1, 1);
        test.append (head1, 1);
        test.append (head1, 2);
        System.out.println(test.isPalindrome (head1));
        ListNode head2 = new ListNode (2);
        test.append (head2, 0);
        test.append (head2, 0);
        test.append (head2, 0);
        test.append (head2, 2);
        System.out.println(test.isPalindrome (head2));
        ListNode head3 = new ListNode (2);
        test.append (head3, 1);
        test.append (head3, 0);
        test.append (head3, 0);
        test.append (head3, 2);
        System.out.println(test.isPalindrome (head3));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null;}
}
