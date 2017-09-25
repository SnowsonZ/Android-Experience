package utils;

import bean.TreeNode;

import java.util.*;

/**
 * Created by Snowson Zhang on 2017/9/24.
 */
public class TreeUtils {

    //广度遍历--层次
    public static void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> tree = new LinkedList<>();
        tree.add(root);
        while (!tree.isEmpty()) {
            TreeNode curNode = tree.removeFirst();
            System.out.print(curNode.getData() + ", ");
            if (curNode.getLeft() != null) {
                tree.add(curNode.getLeft());
            }
            if (curNode.getRight() != null) {
                tree.add(curNode.getRight());
            }
        }
    }

    //广度遍历--递归
    public static void levelTraversalRecursion(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        System.out.println(root.getData());
//        if (root.getLeft() != null) {
//            if (root.getRight() != null) {
//                levelTraversalRecursion(root.getLeft());
//                levelTraversalRecursion(root.getRight());
//            }
//        }
    }

    public static void levelDepth(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> tree = new Stack<>();
        tree.add(root);
        while (!tree.isEmpty()) {
            TreeNode curNode = tree.pop();
            System.out.print(curNode.getData() + ", ");
            if (curNode.getRight() != null) {
                tree.add(curNode.getRight());
            }
            if (curNode.getLeft() != null) {
                tree.add(curNode.getLeft());
            }
        }
    }

    //深度遍历--递归
    public static void levelDepthRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + ", ");
        levelDepthRecursion(root.getLeft());
        levelDepthRecursion(root.getRight());
    }

    //二叉树最大深度--递归
    public static int maxDepthRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepthRecursion(root.getLeft());
        int rightDepth = maxDepthRecursion(root.getRight());
        return 1 + leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public static int maxDepth(TreeNode root) {
        int maxDeepth = 0;
        if (root == null) {
            return maxDeepth;
        }
        LinkedList<TreeNode> tree = new LinkedList<>();
        tree.add(root);
        while (!tree.isEmpty()) {
            int len = tree.size();
            maxDeepth++;
            while (len > 0) {
                len--;
                TreeNode curNode = tree.removeFirst();
                if (curNode.getLeft() != null) {
                    tree.add(curNode.getLeft());
                }
                if (curNode.getRight() != null) {
                    tree.add(curNode.getRight());
                }
            }
        }
        return maxDeepth;
    }
}
