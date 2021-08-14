package _27;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int nums1[] = {3, 2, 2, 3};
        System.out.println(removeElement(nums1, 3));
        System.out.println(Arrays.toString(nums1));
        
        int nums2[] = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums2, 2));
        System.out.println(Arrays.toString(nums2));
    }
    
    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int fast=0;fast<nums.length;fast++) {
            if(nums[fast] != val) {
                nums[slow++] = nums[fast]; 
            }
        }
        return slow;
    }
}
