package _121;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        // This approach didn't work because o(n^2) slow run time
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++) {
            for(int j=i+1;j<prices.length;j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        if(maxProfit < 0) {
            return 0;
        }
        else {
            return maxProfit;
        }
    }
    
    public static int maxProfit2(int prices[]) {
        // Better approach is to use a one pass approach
        // Maintain two variable that keeps track of the smallest value it encounter so far
        // and another variable that keeps track of the max profit 
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++) {
            if(prices[i] < min) {
                // If the current price is smaller than smallest price we have found so far
                // then we will update our min
                min = prices[i];
            }
            else if(prices[i] - min > maxProfit) {
                // If it isn't a smaller value, but gives us a larger profit then we will update our maxProfit
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }
    
    public static void main(String[] args) {
        int nums1[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit2(nums1));
        
        int nums2[] = {7, 6, 4, 3, 1};
        System.out.println(maxProfit2(nums2));
        
        int nums3[] = {1};
        System.out.println(maxProfit2(nums3));
        
        int nums4[] = {1, 4, 8, 1};
        System.out.println(maxProfit2(nums4));
    }
}
