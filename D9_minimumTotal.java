package LeetCode_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class D9_minimumTotal {
    int minSum = Integer.MAX_VALUE;
    int deep = 0;
    public int minimumTotal(List<List<Integer>> triangle) {
        deep = triangle.size();
        dfs(triangle, 0, 0, 0);
        return minSum;
    }

    private void dfs(List<List<Integer>> triangle, int sum, int index, int curDeep) {
        if(curDeep == deep){
            minSum = Math.min(sum, minSum);
            return;
        }
        sum += triangle.get(curDeep).get(index);
        dfs(triangle, sum, index, curDeep + 1);
        dfs(triangle, sum , index + 1, curDeep + 1);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        List<Integer> pre = new ArrayList<>(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> temp = triangle.get(i);
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= pre.size(); j++) {
                if(j == 0 ){
                    cur.add(temp.get(j) + pre.get(j));
                }else if(j == pre.size()){
                    cur.add(temp.get(j) + pre.get(j - 1));
                } else {
                    cur.add(temp.get(j) + Math.min(pre.get(j - 1), pre.get(j)));
                }
            }
            pre = cur;
        }
        int ans = Integer.MAX_VALUE;
        for (Integer integer : pre) {
            ans = Math.min(ans, integer);
        }
        return ans;
    }

}
