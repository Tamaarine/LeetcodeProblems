package _746;

import java.util.Arrays;

public class MinCostStair {
    public static void main(String[] args) {
        
    }   
    
    public static int minCostClimbingStairs(int[] cost) {
        // If there is only two staircase, then it is the minimal of these two
        if(cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        
        // Standard DP, because the cost is never more than or equal to 1000
        // use it as unknown value 
        int dp[] = new int[cost.length];
        Arrays.fill(dp, 1000);
        dp[0] = cost[0];
        dp[1] = cost[1];
        helper(dp, cost, cost.length - 1);
        
        // After constructing the dp, we need to take the minimal between the last two entry because
        // you can leave using the minimal cost getting to the last staircase or the previous staircase 
        return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }
    
    public static int helper(int dp[], int cost[], int n) {
        if(dp[n] == 1000) {
            dp[n] = cost[n] + Math.min(helper(dp, cost, n-1), helper(dp, cost, n-2));
            return dp[n];
        }
        else {
            return dp[n];
        }
    }
}
