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

    /**
     * reverseList - reverse the linked list in place.
     * @param head
     * @return new head
     */
    public static ListNode reverseList(ListNode head) {
        // if 0 or 1 item list, return head
        if ((head == null) || (head.getNext() == null)) {
            return head;
        }

        // we have at least two nodes
        // flip next to point at prev
        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.getNext();
        while (current != null) {
            // reset current's next
            current.setNext(prev);
            // advance iterators
            prev = current;
            current = next;
            if (next != null) {
                next = next.getNext();
            }
        }

        // the last prev is the new head
        return prev;
    }

    /**
     * mergeTwoLists - merge two sorted lists.
     * @param l1
     * @param l2
     * @return head of merged list
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode mergedList = null;
        ListNode currentMerged = null;
        ListNode newMerged = null;
        while ((current1 != null) || (current2 != null)) {
            if ((current1 != null) && (current2 != null)) {
                if (current1.getVal() <= current2.getVal()) {
                    newMerged = new ListNode(current1.getVal());
                    current1 = current1.getNext();
                } else {
                    newMerged = new ListNode(current2.getVal());
                    current2 = current2.getNext();
                }
            } else if (current1 != null) {
                newMerged = new ListNode(current1.getVal());
                current1 = current1.getNext();
            } else if (current2 != null) {
                newMerged = new ListNode(current2.getVal());
                current2 = current2.getNext();
            } else {
                System.out.println("Should not reach here.");
            }

            if (mergedList == null) {
                // set merged list head
                mergedList = newMerged;
                currentMerged = newMerged;
            } else {
                // advance merged list pointer
                currentMerged.setNext(newMerged);
                currentMerged = newMerged;
            }
        }
        return mergedList;
    }
}
