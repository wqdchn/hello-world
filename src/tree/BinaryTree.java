package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @program: hello-world
 * @description: ${description}
 * @author: wqdong
 * @create: 2019-11-07 09:58
 **/
public class BinaryTree {

  public static TreeNode createTree() {
    TreeNode root = new TreeNode(6);

    root.left = new TreeNode(2);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);

    root.right = new TreeNode(8);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);

    return root;
  }

  public static void main(String[] args) {
    TreeNode root = createTree();

    System.out.print("二叉树前序遍历 ");
    preOrder_rec(root);
    System.out.print("\n二叉树前序遍历 ");
    preOrder_itv(root);

    System.out.print("\n二叉树中序遍历 ");
    inOrder_rec(root);
    System.out.print("\n二叉树中序遍历 ");
    inOrder_itv(root);

    System.out.print("\n二叉树后序遍历 ");
    postOrder_rec(root);
    System.out.print("\n二叉树后序遍历 ");
    postOrder_itv(root);

    System.out.println("\n二叉树的最大深度 = " + maxDepth_rec(root));
    System.out.println("二叉树的最大深度 = " + maxDepth_itv(root));

    System.out.println("二叉树的最小深度 = " + minDepth_rec(root));
    System.out.println("二叉树的最小深度 = " + minDepth_itv(root));
  }

  public static void preOrder_rec(TreeNode root) { // 前序遍历，递归
    if (root != null) {
      System.out.print(root.val + " ");
      preOrder_rec(root.left);
      preOrder_rec(root.right);
    }
  }

  public static void preOrder_itv(TreeNode root) { // 前序遍历，非递归
    LinkedList<TreeNode> stack = new LinkedList<>();
    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
      if (node != null) {
        System.out.print(node.val + " ");
        stack.push(node);
        node = node.left;
      } else {
        TreeNode temp = stack.pop();
        node = temp.right;
      }
    }
  }

  public static void inOrder_rec(TreeNode root) { // 中序遍历，递归
    if (root != null) {
      inOrder_rec(root.left);
      System.out.print(root.val + " ");
      inOrder_rec(root.right);
    }
  }

  public static void inOrder_itv(TreeNode root) { // 中序遍历，非递归
    LinkedList<TreeNode> stack = new LinkedList<>();
    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        TreeNode temp = stack.pop();
        System.out.print(temp.val + " ");
        node = temp.right;
      }
    }
  }

  public static void postOrder_rec(TreeNode root) { // 后序遍历，递归
    if (root != null) {
      postOrder_rec(root.left);
      postOrder_rec(root.right);
      System.out.print(root.val + " ");
    }
  }

  public static void postOrder_itv(TreeNode root) { // 后序遍历，非递归
    LinkedList<TreeNode> stack1 = new LinkedList<>();
    LinkedList<TreeNode> stack2 = new LinkedList<>();
    TreeNode node = root;
    if (node != null) {
      stack1.push(node);
    }

    while (!stack1.isEmpty()) {
      node = stack1.pop();
      stack2.push(node);

      if (node.left != null) {
        stack1.push(node.left);
      }
      if (node.right != null) {
        stack1.push(node.right);
      }
    }

    while (!stack2.isEmpty()) {
      System.out.print(stack2.pop().val + " ");
    }
  }

  public static int maxDepth_rec(TreeNode root) { // 深度优先搜索，递归
    return root == null ? 0 : 1 + Math.max(maxDepth_rec(root.left), maxDepth_rec(root.right));
  }

  public static int maxDepth_itv(TreeNode root) { // 广度优先搜索，遍历
    if (root == null) {
      return 0;
    }
    Deque<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int depth = 0;

    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        TreeNode node = q.poll();
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }
      depth++;
    }
    return depth;
  }

  public static int minDepth_rec(TreeNode root) { // 深度优先搜索，递归
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }
    if (root.left == null && root.right != null) {
      return 1 + minDepth_rec(root.right);
    }
    if (root.left != null && root.right == null) {
      return 1 + minDepth_rec(root.left);
    }
    return 1 + Math.min(minDepth_rec(root.left), minDepth_rec(root.right));
  }

  public static int minDepth_itv(TreeNode root) { // 广度优先搜索，遍历
    if (root == null) {
      return 0;
    }
    Deque<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int depth = 0;

    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        TreeNode node = q.poll();

        if (node.left == null && node.right == null) {
          return depth + 1;
        }

        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }
      depth++;
    }
    return depth;
  }

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
