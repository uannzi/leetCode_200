package LeetCode_200;

import java.util.HashMap;
import java.util.Map;

public class D6_numDistinct {

    public int numDistinct(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        int[][] dp = new int[lens + 1][lent + 1];
        for (int i = 0; i < lens + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < lens + 1; i++) {
            for (int j = 1; j < lent + 1; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[lens][lent];
    }
}
