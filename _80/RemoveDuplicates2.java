package _80;

import java.util.Arrays;

public class RemoveDuplicates2 {
    public static void main(String[] args) {
        int input1[] = {1,1,1,2,2};
        System.out.println(removeDuplicates(input1));
        System.out.println(Arrays.toString(input1));
        
        int input2[] = {0, 0, 0, 1, 1, 2, 2, 3,3 ,3 ,4,4,5,6,9,9,9,9};
        System.out.println(removeDuplicates(input2));
        System.out.println(Arrays.toString(input2));
        
        int input3[] = {0, 1, 2, 3, 4, 5, 6, 6, 6};
        System.out.println(removeDuplicates(input3));
        System.out.println(Arrays.toString(input3));
    }
    
    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 2) {
            return nums.length;
        }
        
        // Same idea to use two pointers, slow and fast, and a count which
        // tells us how many of the same elements we have taken so far
        int slow = 0;
        int count = 1;
        for(int fast=1;fast<nums.length;fast++) {
            
            if(nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
                // reset counter
                count = 1;
            }
            else if(nums[slow] == nums[fast] && count < 2) {
                // Not yet hit the limit, we can take it
                slow++;
                nums[slow] = nums[fast];
                count++;
            }
        }
        return slow + 1;
    }
}
