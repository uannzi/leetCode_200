package LeetCode_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D8_generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows == 0){
            return ans;
        }
        ans.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>(Arrays.asList(1));
            List<Integer> pre = ans.get(i - 1);
            for (int j = 1; j < pre.size(); j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);
            ans.add(new ArrayList<>(cur));
        }
        return ans;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>(Arrays.asList(1));
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> cur = new ArrayList<>(Arrays.asList(1));
            for (int j = 1; j < pre.size(); j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);
            pre = cur;
        }
        return pre;
    }
}
