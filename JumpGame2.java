public class JumpGame2 {
    public static void main(String[] args) {
        int nums1[] = {1,2,1,1,1};
        System.out.println(jump(nums1));
        
        // int nums2[] = {2, 3, 0, 1, 4};
        // System.out.println(jump(nums2));
        
        int nums3[] = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(jump(nums3));
        
    }
    
    public static int jump(int nums[]) {
        int count = 0;
        int left = 0;
        int right = 0;
        
        int max = 0;
        
        while(right < nums.length - 1) {
            System.out.println(left);
            // Figure out the max
            int wastedSpace = right - left;
            int contributed = nums[left] - wastedSpace;
            
            int maxWasted = right - max;
            int maxContributed = nums[max] - maxWasted;
            
            if(contributed > 0 && contributed > maxContributed) {
                max = left;
            }
            
            if(left == right) {
                // Update the right side limit
                maxWasted = right - max;
                maxContributed = nums[max] - maxWasted;
                right = right + maxContributed;
                count++;
                left++;
                max = left;
                continue;
            }
            left++;
        }
        
        return count;
    }
}
