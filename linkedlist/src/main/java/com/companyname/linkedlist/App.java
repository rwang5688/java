package com.companyname.linkedlist;

/**
 * Linked List app.
 */
public final class App {
    private static final int NUM_NODES = 5;

    private App() {}

    /**
     * createList - create a list of 1 .. numNodes.
     * @param numNodes
     * @return head of list
     */
    private static ListNode createList(int numNodes) {
        if (numNodes <= 0) {
            return null;
        }

        ListNode lastNode = new ListNode(numNodes);
        ListNode current = null;
        ListNode next = lastNode;
        for (int i = numNodes - 1; i > 0; i--) {
            current = new ListNode(i, next);
            next = current;
        }
        return current;
    }

    /**
     * printList - print a list.
     * @param head
     */
    private static void printList(ListNode head) {
        // empty list - print nothing
        if (head == null) {
            return;
        }

        // print header
        System.out.print("List : ");

        // print contents
        ListNode node = head;
        while (node != null) {
            System.out.print(node.getVal() + "->");
            node = node.getNext();
        }

        // print trailer
        System.out.println("");
    }

    /**
     * Demonstrate Linked List functions.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Linked List demonstrations.");

        // delete the NUM_NODES - 2 th node
        System.out.println("ListUtils.deleteNode:");
        ListNode head1 = App.createList(NUM_NODES);
        App.printList(head1);
        ListNode node = head1;
        for (int i = 0; i < NUM_NODES - 2; i++) {
            node = node.getNext();
        }
        System.out.println("Deleting node: " + node.getVal());
        ListUtils.deleteNode(node);
        App.printList(head1);

        // remove the NUM_NODES - 2 th node
        System.out.println("ListUtils.removeNthFromEnd:");
        ListNode head2 = App.createList(NUM_NODES);
        App.printList(head2);
        head2 = ListUtils.removeNthFromEnd(head2, NUM_NODES);
        App.printList(head2);
    }
}
