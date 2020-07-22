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
     * findMaxDepth - recursive private method for finding max depth.
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

    /**
     * isValidBST - check if tree is a strict binary search tree.
     * @param root
     * @return false if any value is dup or values are not sorted as a strict BST; otherwise true
     */
    public static boolean isValidBST(TreeNode root) {
        // if any node returns false, then whole tree is false
        return isValidBSTWithinRange(root, null, null);
    }

    /**
     * isValidBSTWithinRange - recursive private method for checking sub-tree is within range.
     * @param root
     * @param lower
     * @param upper
     * @return
     */
    private static boolean isValidBSTWithinRange(TreeNode root, Integer lower, Integer upper) {
        // empty tree is always valid
        if (root == null) {
            return true;
        }

        // am I within range?
        if ((lower != null) && (root.getVal() <= lower)) {
            return false;
        }
        if ((upper != null) && (root.getVal() >= upper)) {
            return false;
        }

        // check my left sub-tree
        if (root.getLeft() != null) {
            if (!isValidBSTWithinRange(root.getLeft(), lower, root.getVal())) {
                return false;
            }
        }

        // check my right sub-tree
        if (root.getRight() != null) {
            if (!isValidBSTWithinRange(root.getRight(), root.getVal(), upper)) {
                return false;
            }
        }

        // sub-trees are valid
        return true;
    }
}
