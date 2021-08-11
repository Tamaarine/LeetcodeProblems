package _217;

import java.util.Arrays;

public class ContainDuplicate {
    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums1));
        
        int nums2[] = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums2));
        
        int nums3[] = {1, 1, 1, 3 ,3 ,4 , 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums3));
    }
    
    public static boolean containsDuplicate(int[] nums) {
        // Sort the number first
        Arrays.sort(nums);
        
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
