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
}
