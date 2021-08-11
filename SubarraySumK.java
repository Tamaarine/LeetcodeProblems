import java.util.HashMap;

public class SubarraySumK {
    public static void main(String[] args) {
        int input1[] = {0, 3, 7, 3, 0, 1, 2};
        System.out.println(subarraySum(input1, 3));
    }
    
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // The idea is to use pre sum and hashmap
        // sum[i, j] gives us the sum between two indices, if we know sum[0, i -1] which is just a
        // cumulative sum and we know sum[0, j] which again is also a cumulative we can easily
        // find sum[i, j] by just subtracting them which allow us to get sum between any two indices
        // We save all the cumulative sum we have seen so far in the HashMap, mapping the sum to
        // the number of occurneces
        int sum = 0;
        int counter = 0;
        
        // Have to put 0 to 1 because that means a direct subarray from 0 to y sums up to k.
        // We initially put it there just in case there is a subarray that does add up to k directly
        
        map.put(0, 1);
        
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            
            // If the HashMap contains sum - k, that means it is possible to have an subarray
            // which sums up to k. Let y be the running sum right now, and x be sum - k
            // which is running sum from [0, x]. If it exist then that means k can be achieved
            // by summing from [x, y] to reach k
            if(map.containsKey(sum - k)) {
                // We add to counter the number of times sum - k exists
                counter += map.get(sum - k);
            }
            
            // Then after we used the running sum, we have to put the running sum into the hashmap
            // for the next iteration to check
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return counter;
    }
}
