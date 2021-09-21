package _322;

public class CoinExchange {
    
    public static void main(String[] args) {
        
    }
    
    public int coinChange(int[] coins, int amount) {
        // Cannnot just do use the biggest coin change, it won't work
        if(amount <= 0) {
            return 0; // no amount of coins
        }
        // coin is just coins, the dp will be size amount, we will have every
        // possible amount, say if amount is 7, then we have how many minimal coins
        // we need to sum to 1, 2, 3, ... all the way up to 7, that's our dp array
        // remain will start with amount because we are interested in the minimal coins we need to sum to amount
        return helper(coins, new int[amount], amount);
    }
    
    public static int helper(int coins[], int dp[], int remain) {
        if(remain < 0) return -1; // invalid remain to be on, cannot sum to the desire target
        if(remain == 0) return 0; // perfect we can sum to it exactly, return 0 to indicate that we can indeed sum to the target
        if(dp[remain-1] != 0) return dp[remain-1]; // we already computed the minimal number of coins needed for this target
        
        int min = Integer.MAX_VALUE; // assume the minimal is a really large number so we can decrease it with any sum 
        
        // we can just return the answer we have already computed 
        for(int i=0;i<coins.length;i++) {
            int ret = helper(coins, dp, remain - coins[i]); // do a recursive call to recursively find the answer to sum to remain
            
            // We update the minimal number of coins to sum to remain if ret returned 0 or something greater than 0
            // if it is 0, then is like saying remain is 5, we took a coin worth 5 and that's it
            // we just need to update min to 1 plus ret.
            // If it is greater than 0 that means the answer came from dp and is the minimal
            // we just need to add 1 to that answer because we used a coin coin[i] and update our min
            if(ret >= 0 && ret < min) {
                min = 1 + ret;
            }
        }
        
        // After the previous for loop, it try all the coin combination along with dp to find the
        // minimal coins sum to remain, then we can update dp here
        dp[remain - 1] = min == Integer.MAX_VALUE ? 0 : min; // only update if min is changed 
        return dp[remain - 1]; // return the dp value
    }
}
