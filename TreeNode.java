package LeetCode_200;

public class TreeNode {
    public int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", leftNode=" + left +
                ", rightNode=" + right +
                '}';
    }
}
