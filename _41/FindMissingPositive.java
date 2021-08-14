package _41;

import java.util.HashMap;

public class FindMissingPositive {
    public static void main(String[] args) {
        int nums1[] = {1, 2, 0};
        System.out.println(firstMissingPositive(nums1));
        
        int nums2[] = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums2));
        
        int nums3[] = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums3));
        
        int nums4[] = new int[10000];
        for(int i=-2;i<10000 - 2;i++) {
            nums4[i + 2] = i;
        }
        System.out.println(firstMissingPositive(nums4));
    }
    
    public static int firstMissingPositive2(int[] nums) {
        int counter = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0 && nums[i] < nums.length) {
                int temp = nums[i];
                nums[i] = 0; // set this element to 0 because we finished reading it
                nums[temp - 1] = 1;
            }
            else {
                // Element that is less than or equal to 0 which we don't care
                // so we set it to 0
                nums[i] = 0;
            }
        }
        
    }
    
    public static int firstMissingPositive(int[] nums) {
        // Map positive Integer to whether or not it is seen in nums
        HashMap<Integer, Boolean> map = new HashMap<>();    
        
        for(int i : nums) {
            if(i > 0) {
                map.put(i, true);
            }
        }
        
        for(int i=1;i<Integer.MAX_VALUE;i++) {
            if(!map.getOrDefault(i, false)) {
                return i;
            }   
        }
        return 0;
    }
}
