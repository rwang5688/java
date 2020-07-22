package com.companyname.trees;

import java.util.LinkedList;

/**
 * Hello Trees!
 */
public final class App {
    private static final int NODE1_VAL = 3;
    private static final int NODE2_VAL = 9;
    private static final int NODE3_VAL = 20;
    private static final int NODE4_VAL = 15;
    private static final int NODE5_VAL = 7;

    private App() {}

    /**
     * createTree.
     * @return root of tree
     */
    private static TreeNode createTree() {
        TreeNode node1 = new TreeNode(NODE1_VAL);
        TreeNode node2 = new TreeNode(NODE2_VAL);
        TreeNode node3 = new TreeNode(NODE3_VAL);
        TreeNode node4 = new TreeNode(NODE4_VAL);
        TreeNode node5 = new TreeNode(NODE5_VAL);

        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);

        return node1;
    }

    /**
     * printTree - print tree in depth first order.
     * @param head
     */
    private static void printTree(TreeNode root) {
        // empty tree - print nothing
        if (root == null) {
            return;
        }

        // print header
        System.out.print("Tree (in BFS order) : [ ");

        // print contents
        TreeNode node = root;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.remove();
            if (node == null) {
                System.out.print("null ");
            } else {
                System.out.print(node.getVal() + " ");
                // visit children
                queue.add(node.getLeft());
                queue.add(node.getRight());
            }
        }

        // print trailer
        System.out.println("]");
    }

    /**
     * Says hello to Trees.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello Trees!");

        // max depth
        System.out.println("maxDepth:");
        TreeNode tree1 = createTree();
        printTree(tree1);
        int maxDepth = TreeUtils.maxDepth(tree1);
        System.out.println("Tree's max depth: " + maxDepth);

        // isValidBST
        System.out.println("isValidBST:");
        TreeNode tree2 = createTree();
        printTree(tree2);
        boolean isValidBST = TreeUtils.isValidBST(tree2);
        System.out.println("Tree is a valid binary search tree: " + isValidBST);
    }
}
