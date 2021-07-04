package LeetCode_200;

import java.util.ArrayList;
import java.util.List;

public class D10_sort {
    public List<List<Integer>> sort(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), 0, nums);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, ArrayList<Integer> temp, int index, int[] nums) {
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!temp.contains(nums[i])) {
                temp.add(nums[i]);
                dfs(ans, temp, index + 1, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
