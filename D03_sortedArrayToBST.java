package LeetCode_200;

import java.util.List;

public class D03_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);
        return node;
    }

    private ListNode listNode;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        int len = getLen(head);
        listNode = head;
        return sortedListToBST(0, len - 1);
    }

    private TreeNode sortedListToBST(int start, int end) {
        if(start > end){
            return null;
        }
        TreeNode node = new TreeNode(0);
        int mid = start + (end - start) / 2;
        node.left = sortedListToBST(start, mid - 1);
        node.val = listNode.val;
        listNode = listNode.next;
        node.right = sortedListToBST(mid + 1, end);
        return node;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }
}
