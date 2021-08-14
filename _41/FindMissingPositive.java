package _41;

import java.util.HashMap;

public class FindMissingPositive {
    public static void main(String[] args) {
        int nums1[] = {1, 2, 0};
        System.out.println(firstMissingPositive2(nums1));
        
        int nums2[] = {3, 4, -1, 1};
        System.out.println(firstMissingPositive2(nums2));
        
        int nums3[] = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive2(nums3));
        
        int nums4[] = new int[10000];
        for(int i=-2;i<10000 - 2;i++) {
            nums4[i + 2] = i;
        }
        System.out.println(firstMissingPositive2(nums4));
    }
    
    public static int firstMissingPositive2(int[] nums) {
        // Go through the nums and mark all those that are useless
        // to just be length of nums + 1
        // We only care about the range of numbers between [1, n] because
        // if there is a missing positive number then it has to be either
        // within the range of [1, n] or just n + 1. If it is n + 1 that means
        // all the numbers between [1, n] exists once
        for(int i=0;i<nums.length;i++) {
            if(nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = nums.length + 1;
            }
        }
        
        // Then we will go through the nums again to mark indexes
        for(int i=0;i<nums.length;i++) {
            int index = Math.abs(nums[i]); // need to use abs because if we mark the elements
            if(index > nums.length) {
                // We don't care just continue, we don't mark because this
                // number is greater than n we can't mark it anywhere
                continue;
            }   
            index--; // 0-based index so we have to subtract 1
            // However, if it is less than nums.length we can use this
            // index's element and mark the element to be negative
            // saying that oh we did have a number of value index + 1. 0-based position
            if(nums[index] > 0) {
                // Prevent double negative
                nums[index] = -1 * nums[index];
            }
        }
        
        // Then finally just walk through the nums again
        // and find the first index element that is positive return that index + 1
        // will be the first missing positive integer
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }
        
        // Otherwise we walked through the entire array and everything
        // is marked as negative, hence return n + 1
        return nums.length + 1;
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
