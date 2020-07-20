package com.companyname.linkedlist;

/**
 * List utilities.
 */
public final class ListUtils {

    private ListUtils() {}

    /**
     * deleteNode - delete a node as specified by node.
     * @param node
     */
    public static void deleteNode(ListNode node) {
        ListNode next = node.getNext();
        node.setVal(next.getVal());
        node.setNext(next.getNext());
    }

    /**
     * removeNthFromEnd - assuming first node is 0th node,
     * remove the length - n node.
     * @param head
     * @param n
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        System.out.println("removeNthFromEnd: n=" + n);
        // count length of list
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.getNext();
            length++;
        }

        // make sure it's safe to remove
        int toBeRemoved = length - n;
        if (toBeRemoved < 0) {
            return head;
        }

        // advance to node just before node to be removed
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.getNext();
        for (int i = 0; i < toBeRemoved; i++) {
            prev = current;
            current = next;
            next = next.getNext();
        }

        // if head is being removed, return head's next as new head
        if (prev == null) {
            return next;
        }

        // otherwise, remove node and return head
        prev.setNext(next);
        return head;
    }
}
