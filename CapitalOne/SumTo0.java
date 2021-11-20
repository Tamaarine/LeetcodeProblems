package CapitalOne;

import java.util.Arrays;

public class SumTo0 {
    public static void main(String[] args) {
        int input1[] = {-1, 0, 2, -5, 7, 1,-2};
        printArray(sum0(input1));
    }
    
    public static void printArray(int nums[]) {
        if(nums == null) return;
        for(int x : nums) {
            System.out.print(x + ", ");
        }
        System.out.println();
    }
    
    public static int[] sum0(int nums[]) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int reLeft = left;
        int reRight = right;
        int currentSmallest = nums[reRight] + nums[reLeft];
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(Math.abs(currentSmallest) > Math.abs(sum)) {
                reLeft = left;
                reRight = right;
            }
            
            if(sum < 0) {
                // Too small increase left
                left += 1;
            }
            else if(sum > 0) {
                // Too big
                right -= 1;
            }
            else {
                int output[] = {nums[reLeft], nums[reRight]};
                return output;
            }
        }
        int output[] = {nums[reLeft], nums[reRight]};
        return output;
    }
    
}