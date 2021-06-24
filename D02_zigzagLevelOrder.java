package LeetCode_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class D02_zigzagLevelOrder {
    /*
    对ArrayList进行插入操作事实上效率并不高，当size非常大的时候插入是需要更新的坐标很多，所以不建议使用这个方法
    建议使用双端队列，通过一个flag来判断前进尾出还是尾进前出
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        List<Integer> lever = new ArrayList<>();
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        TreeNode last = root, nextLast = null;
        boolean left = true;
        while(!temp.isEmpty()){
            TreeNode node = temp.poll();
            if(left) {
                lever.add(node.val);
            }else {
                lever.add(0, node.val);
            }
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
                left = !left;
            }
        }
        return ans;
    }


    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        bfs(root, 1, ans);
        return ans;
    }

    private void bfs(TreeNode node, int level, List<List<Integer>> ans) {
        if(node == null){
            return;
        }
        if(ans.size() < level){
            ans.add(new ArrayList<>());
        }
        if(level % 2 == 0){
            ans.get(level - 1).add(0, node.val);
        }else {
            ans.get(level - 1).add(node.val);
        }
        bfs(node.left, level + 1, ans);
        bfs(node.right, level + 1, ans);
    }
}
