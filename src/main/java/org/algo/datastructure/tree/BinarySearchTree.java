package org.algo.datastructure.tree;

import java.util.ArrayDeque;

public class BinarySearchTree {

    public static void main(String[] args) {
        var root = new TreeNode(5, new TreeNode(4), new TreeNode(10));
        insert(root, 12);
//        System.out.println(root);
//        remove(root, 4);
//        System.out.println("Search: " + search(root, 4));
        breadthFirstSearch(root);
    }

    public static TreeNode search(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            return search(root.right, key);
        } else if (key < root.val) {
            return search(root.left, key);
        }

        return root;
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = insert(root.right, val);
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        }

        return root;
    }

    public static TreeNode remove(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = remove(root.right, val);
        } else if (val < root.val) {
            root.left = remove(root.left, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                var minNode = minTreeNode(root);
                root.val = minNode.val;
                root.right = remove(root.right, val);
            }
        }

        return root;
    }

    public static TreeNode minTreeNode(TreeNode root) {
        var curr = root;

        while (root != null && root.left != null) {
            curr = curr.left;
        }

        return curr;
    }

    public static void depthFirstSearch(TreeNode root) {
        if (root == null) {
            return;
        }

        depthFirstSearch(root.left);
        System.out.print(root.val + " ");
        depthFirstSearch(root.right);
    }

    public static void breadthFirstSearch(TreeNode root) {
        var deque = new ArrayDeque<TreeNode>();

        if (root != null) {
            deque.add(root);
        }

        while (!deque.isEmpty()) {
            var level = 0;

            var n = deque.size();
            for (int i = 0; i < n; i++) {
                var node = deque.pollFirst();
                System.out.print(node.val + " ");

                if (node.left != null) {
                    deque.add(node.left);
                }

                if (node.right != null) {
                    deque.add(node.right);
                }
            }

            System.out.println();
            System.out.println("Level: " + level);
            level++;
        }
    }
}
