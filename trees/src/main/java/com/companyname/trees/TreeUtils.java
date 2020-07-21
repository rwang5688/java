package com.companyname.trees;

/**
 * Tree Utilities.
 */
public final class TreeUtils {

    private TreeUtils() {}

    /**
     * maxDepth.
     * @param root
     * @return maximum tree depth
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = TreeUtils.findMaxDepth(root, 1);
        return maxDepth;
    }

    /**
     * findMaxDepth - recursive method for finding max depth.
     * @param currentNode
     * @param currentDepth
     * @return maximum tree depth
     */
    private static int findMaxDepth(TreeNode currentNode, int currentDepth) {
        // base case: return where I am
        if ((currentNode.getLeft() == null) && (currentNode.getRight() == null)) {
            return currentDepth;
        }

        // recursive cases: find how deep left and right paths go
        int leftMaxDepth = currentDepth;
        int rightMaxDepth = currentDepth;
        if (currentNode.getLeft() != null) {
            leftMaxDepth = findMaxDepth(currentNode.getLeft(), currentDepth + 1);
        }
        if (currentNode.getRight() != null) {
            rightMaxDepth = findMaxDepth(currentNode.getRight(), currentDepth + 1);
        }

        // compare and return bigger value
        return (leftMaxDepth > rightMaxDepth) ? leftMaxDepth : rightMaxDepth;
    }
}
