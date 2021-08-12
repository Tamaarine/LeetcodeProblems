package _15;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum
{
    public static void main(String [] args)
    {
        int arr1[] = {-1,0,1,2,-1,4};
        print2DArray(threeSum(arr1));
        
        
        
    }
    
    /**
     * Given an array nums of n integers, are there elements a,b,c in nums such that
     * a + b + c = 0. Find all the unique triplets in the array no duplicates are allowed
     * 
     * @param nums
     * @return 
     */
    public static List<List<Integer>> threeSum(int[] nums) 
    {
        // Our output for storing the triplets of numbers that adds up to 0
        List<List<Integer>> output = new ArrayList<>();
        
        // First we have to sort the given array
        Arrays.sort(nums);
        
        // We will use a for loop to go through nums
        for(int i=0;i<nums.length;i++)
        {
            // We want to move onto to the next integer
            // if the integer we are at right now is the same as the previous one
            if(i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }
            
            // However if we are here then that means we can proceed to search through
            // the other elements to find sums that are zero
            int l = i + 1;
            int r = nums.length - 1;
            
            // While the left index is less than r index we will continue to search for
            // the equal sum of 0
            while(l < r)
            {
                int sum = nums[i] + nums[l] + nums[r];
                
                // The sum is greater than 0 hence we have to decrease r
                if(sum > 0)
                {
                    r--;
                }
                // The sum is less than 0 hence we have to increase l
                else if(sum < 0)
                {
                    l++;
                }
                // The sum is equal to 0 hence we have to put the 3 ints pair into the list
                else
                {
                    ArrayList<Integer> toAppend = new ArrayList<>();
                    toAppend.add(nums[i]);
                    toAppend.add(nums[l]);
                    toAppend.add(nums[r]);
                    
                    output.add(toAppend);
                    
                    // Now after adding this one we have to increment the left only
                    // to get rid of any duplicatives elements. We only have to do it for
                    // one side only the left side and don't have to handle the other side
                    // because the right side's duplicatives will be handle by the sum > 0
                    l++; // We add 1 to increment the left counter
                    
                    // Then we have to make sure we get rid of all of the duplicatives
                    // If the incremented L is equal to the same element, then we have to
                    // increment L again, but we have to make sure that l < r to not go overboard
                    while(nums[l] == nums[l - 1] && l < r)
                    {
                        l++;
                    }
                }
            }
        }
        
        return output;
        
    }
    
    public static void print2DArray(List<List<Integer>> nums)
    {
        for(List l: nums)
        {
            System.out.println(l);
        }
    }
}