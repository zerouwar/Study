package cn.chenhuanming.leet.code.medium;

import cn.chenhuanming.leet.code.common.Node;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 */
public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {
        Node ans = new 二叉搜索树与双向链表().treeToDoublyList(Node.createTree(new int[]{1}, new int[]{1}));
        System.out.println(ans.val);
    }

    private Node head;
    private Node p;

    public Node treeToDoublyList(Node root) {
        predecessor(root);
        if (head != null && head != p) {
            p.right = head;
            head.left = p;
        }
        return head;
    }

    private void predecessor(Node node) {
        if (node == null) {
            return;
        }
        predecessor(node.left);
        if (head == null) {
            head = node;
        }
        if (p != null) {
            p.right = node;
            node.left = p;
        }
        p = node;
        predecessor(node.right);
    }
}
