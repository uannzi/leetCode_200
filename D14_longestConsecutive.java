package LeetCode_200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class D14_longestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length, max = 1;
        Set<Integer> set = new HashSet<>();
        for (int v : nums) set.add(v);

        for (int v : nums) {
            // 技巧：如果有比自己小一点的，那自己不查，让小的去查
            if (set.contains(v - 1)) continue;

            int r = v; // r: right 表示「以 v 开头，能连续到多少
            while (set.contains(r + 1)) r++; // 逐个查看
            max = Math.max(max, r - v + 1); // 记录区间 [v, r] 长度
        }
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int len = 1;
                while (set.contains(++i)){
                    len++;
                }
                maxLen = Math.max(maxLen,len);
            }
        }
        return maxLen;

    }
}
