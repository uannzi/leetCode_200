package LeetCode_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D01_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        List<Integer> lever = new ArrayList<>();
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        TreeNode last = root, nextLast = null;
        while(!temp.isEmpty()){
            TreeNode node = temp.poll();
            lever.add(node.val);
            if(node.left != null){
                nextLast = node.left;
                temp.offer(node.left);
            }
            if(node.right != null){
                nextLast = node.right;
                temp.offer(node.right);
            }
            if(node == last){
                ans.add(new ArrayList<>(lever));
                lever.clear();
                last = nextLast;
            }
        }
        return ans;
    }

    //BFS遍历
    public List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        bfs(root, 1, ans);
        return ans;
    }

    private void bfs(TreeNode node, int lever, List<List<Integer>> ans) {
        if(node == null){
            return;
        }
        if(ans.size() < lever){
            ans.add(new ArrayList<>());
        }
        ans.get(lever - 1).add(node.val);
        bfs(node.left,lever + 1, ans);
        bfs(node.right,lever + 1, ans);
    }
}
