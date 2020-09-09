package com.tan.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 翻转一棵树
 * Created by Administrator on 2020/8/20.
 */
public class InvertTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode();
        root.nodeValue = 4;

        TreeNode left = new TreeNode();
        left.nodeValue = 2;
        TreeNode left_left = new TreeNode();
        left_left.nodeValue = 1;
        TreeNode left_right = new TreeNode();
        left_right.nodeValue = 3;
        left.leftNode=left_left;
        left.rightNode=left_right;

        TreeNode right = new TreeNode();
        right.nodeValue = 7;
        TreeNode right_left = new TreeNode();
        right_left.nodeValue = 6;
        TreeNode right_right = new TreeNode();
        right_right.nodeValue = 9;
        right.leftNode=right_left;
        right.rightNode=right_right;

        root.leftNode=left;
        root.rightNode=right;

        TreeNode treeNode = invertTree(root);


    }


    public static TreeNode invertTree(TreeNode root) {

        Set set = new HashSet();


        // 判断根节点是否存在
        if (root == null) {
            return null;
        }

        // 利用递归先交换左边/右边的叶子结点
        // 例如 最后有两个叶子结点 2 4
        TreeNode left = invertTree(root.leftNode);
        TreeNode right = invertTree(root.rightNode);
        root.leftNode = right;
        root.rightNode = left;


        return root;
    }

}

class TreeNode {
    public int nodeValue;
    public TreeNode leftNode;
    public TreeNode rightNode;


}
