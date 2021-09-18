package _1137;

import java.util.Arrays;

public class NthTribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }
    
    public static int helper(int dp[], int n) {
        if(dp[n] == -1) {
            dp[n] = helper(dp, n-1) + helper(dp, n-2) + helper(dp, n-3);
            return dp[n];
        }
        else {
            return dp[n];
        }
    }

    public static int tribonacci(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 1;
        else {
            int dp[] = new int[n+1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;            
            return helper(dp, n);
        }
    }
}
