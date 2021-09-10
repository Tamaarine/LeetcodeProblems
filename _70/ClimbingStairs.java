package _70;

public class ClimbingStairs {
    
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
    
    public static int climbStairs(int n) {
        int dp[] = new int[n];
        
        if(n == 1) {
            return 1;
        }
        else if(n == 2) {
            return 2;
        }
        else {
            dp[0] = 1;
            dp[1] = 2;
            return helper(dp, n - 1);
        }
        
    }
    
    public static int helper(int dp[], int n) {
        if(dp[n] == 0) {
            // Need to build the dp
            dp[n] = helper(dp, n - 1) + helper(dp, n - 2);
            return dp[n];
        }
        else {
            return dp[n];
        }
    }
}
