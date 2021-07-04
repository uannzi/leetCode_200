package LeetCode_200;

import java.util.Deque;
import java.util.Stack;

public class D12_maxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        hleper(root);
        return maxSum;
    }

    private int hleper(TreeNode node) {
        if(node == null){
            return 0;
        }
        int leftGain = Math.max(hleper(node.left), 0);
        int rightGain = Math.max(hleper(node.right), 0);

        int sum = leftGain + rightGain + node.val;
        maxSum = Math.max(maxSum, sum);
        return node.val + Math.max(leftGain, rightGain);
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left != right){
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right){
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
}
