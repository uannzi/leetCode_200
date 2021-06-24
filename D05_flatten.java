package LeetCode_200;

import java.util.LinkedList;
import java.util.Queue;

public class D05_flatten {
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while (node != null){
            if(node.left == null){
                node = node.right;
                continue;
            }
            TreeNode next = node.left;
            TreeNode pre = next;
            while (pre.right != null){
                pre = pre.right;
            }
            pre.right = node.right;
            node.right = node.left;
            node.left = null;
            node = node.right;
        }
    }
}
