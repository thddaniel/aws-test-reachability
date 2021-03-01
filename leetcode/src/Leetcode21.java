
import java.util.Arrays;
import java.util.List;

public class Leetcode21 {
    public static void main(String[] args) {
        Solution21 s = new Solution21();
        s.run();
    }
}

class Solution21 {
    public void run() {
        List l1List = Arrays.asList(1, 2, 4);
        List l2List = Arrays.asList(1, 3, 4);
        ListNode l1 = createListNode(l1List);
        ListNode l2 = createListNode(l2List);
        ListNode result = mergeTwoLists(l1, l2);
        print(result);
    }

    public void print(ListNode l) {
        while (l !=null) {
            System.out.print(l.val);
            l = l.next;
        }
    }

    public ListNode createListNode(List<Integer> list) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        for (int num: list) {
            prev.next = new ListNode(num);
            prev = prev.next;
        }
        return prehead.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
