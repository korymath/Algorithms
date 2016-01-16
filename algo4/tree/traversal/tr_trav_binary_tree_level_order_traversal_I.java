package traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 * For example:
 *
 * Given binary tree {3,9,20,#,#,15,7},
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/}
 *
 */
public class tr_trav_binary_tree_level_order_traversal_I {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> p = new LinkedList<TreeNode>(),
                        q = new LinkedList<TreeNode>();

        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();

            /*
             * Juggle "q" to "p" for current iteration. Use "p" to store
             * next level.
             */
            p = new LinkedList<TreeNode>(q);
            q.clear();

            while (!p.isEmpty()) {
                TreeNode c = p.poll();
                level.add(c.val);

                if (c.left != null) {
                    q.add(c.left);
                }

                if (c.right != null) {
                    q.add(c.right);
                }
            }

            result.add(level);
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        q.add(root);
        q.add(null);

        while (true) {
            TreeNode c = q.poll();

            if (c == null) {
                result.add(new ArrayList<Integer>(level));
                level.clear();

                if (q.isEmpty()) {
                    break;
                }

                q.add(null);
            } else {
                level.add(c.val);

                if (c.left != null) {
                    q.add(c.left);
                }

                if (c.right != null) {
                    q.add(c.right);
                }
            }
        }

        return result;
    }
}