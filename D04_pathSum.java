package LeetCode_200;

import java.util.ArrayList;
import java.util.List;

public class D04_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        pathSum(ans, temp, root, targetSum, root.val);
        return ans;
    }

    private  void pathSum(List<List<Integer>> ans, ArrayList<Integer> temp, TreeNode node, int targetSum, int sum) {
        if(node.left == null && node.right == null && sum == targetSum){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(node.left != null){
            temp.add(node.left.val);
            pathSum(ans, temp, node.left, targetSum, sum + node.left.val);
            temp.remove(temp.size() - 1);
        }
        if(node.right != null){
            temp.add(node.right.val);
            pathSum(ans, temp, node.right, targetSum, sum + node.right.val);
            temp.remove(temp.size() - 1);
        }
    }
}
