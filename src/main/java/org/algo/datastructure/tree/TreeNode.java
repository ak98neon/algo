package org.algo.datastructure.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);

        if (left != null) {
            sb.append(" Left: ").append(left);
        }

        if (right != null) {
            sb.append(" Right: ").append(right);
        }

        return sb.toString();
    }
}
