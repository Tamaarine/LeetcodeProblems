package _198;

import java.util.Arrays;

public class HouseRobber {
    
    public static void main(String[] args) {
        int input1[] = {1, 2, 3, 1};
        System.out.println(rob(input1));
        
        int input2[] = {2, 7, 9, 3, 1};
        System.out.println(rob(input2));
    }
    
    public static int rob(int[] nums) {
        // Need to be solved throgh DP
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1); // To avoid the  problem of all 0 array which will cause the worse case scenario, it will go through
        // every single recursion call without using the dp array at all so we need to fill it with -1
        return helper(nums, nums.length - 1, dp);
    }
    
    public static int helper(int nums[], int index, int dp[]) {
        if(index < 0) {
            return 0;
        }
        else {
            if(dp[index] == -1) {
                dp[index] = Math.max(nums[index] + helper(nums, index - 2, dp), helper(nums, index - 1, dp));
            }
            return dp[index];
        }
    }
}
