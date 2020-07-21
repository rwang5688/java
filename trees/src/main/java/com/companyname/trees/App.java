package com.companyname.trees;

import java.util.Stack;

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
        System.out.print("Tree (in DFS order) : [ ");

        // print contents
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node != null) {
            System.out.print(node.getVal() + " ");
            // visit new children
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            // get next
            if (!stack.isEmpty()) {
                node = stack.pop();
            } else {
                node = null;
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
        TreeNode tree1 = createTree();
        printTree(tree1);
        int maxDepth = TreeUtils.maxDepth(tree1);
        System.out.println("Tree's max depth: " + maxDepth);
    }
}
