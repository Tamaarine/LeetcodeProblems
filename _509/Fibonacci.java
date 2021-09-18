package _509;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        
    }
    
    public static int fib(int n) {
        int dp[] = new int[n+1];
        
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        else {
            Arrays.fill(dp, -1);
            dp[0] = 0;
            dp[1] = 1;
            return helper(dp, n);
        }
    }
    
    public static int helper(int dp[], int n) {
        if(dp[n] == -1) {
            // memo doesn't have the answer yet
            dp[n] = helper(dp, n - 1) + helper(dp, n - 2);
            return dp[n];
        }
        else {
            return dp[n];
        }
    }
}
