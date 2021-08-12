package _16;


import java.util.Arrays;

public class ThreeSumClosest
{
    public static void main(String[] args) 
    {
        int arr1[] = {-1,2,1,-4};
        System.out.println(threeSumClosest(arr1, 1));
        
        int arr2[] = {1,1,1,1};
        System.out.println(threeSumClosest(arr2, 0));
    
    }
    
    /**
     * This function given an array of n integers and an integer target, will
     * find three integers in the array such that the sum is closest to target
     * and it will return the sum of the three integers. We can assume that the
     * input would only have one solution
     * 
     * This is the more efficient solution compared to using triple for loop
     * 
     * @param nums Given array to search through
     * @param target The integer that we are aiming to sum closest to
     * @return Returns the sum of 3 integers such that it is closest to target
     */
    public static int threeSumClosest(int nums[], int target)
    {
        int diff = Integer.MAX_VALUE;
        int output = 0;
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++)
        {
            System.out.println(i);
            // If the index is greater than 0 and that the current element is the same
            // as the previous element then we will just continue to the next element 
            // without checking further
            if(i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }

            // Then if we are here then that means we aren't at a duplicate
            // element which we have searched through already 
            int left = i + 1;
            int right = nums.length - 1;

            // We will use this while loop for summing up and check for the closest integer
            while(left < right)
            {
                int leftInt = nums[left];
                int rightInt = nums[right];
                int iInt = nums[i];

                int sum = leftInt + rightInt + iInt;

                int newSumDiff = Math.abs(sum - target);
                
                // Our newSumDiff is even closer to the target hence we update the diff
                if(newSumDiff < diff)
                {
                    diff = newSumDiff;
                    output = sum;
                }
                
                // The sum is too small hence we move up the left side
                if(sum - target < 0)
                {
                    left++;
                }
                // Sum is too big hence we move down the right side
                else if(sum - target > 0)
                {
                    right--;
                }
                // The sum is just equal to 0 which is the closest we can get
                // hence we just return 0 and out
                else
                {
                    return target;
                }
            }
        }
        
        return output;
    }
    
    public static int threeSumClosestTwo(int nums[], int target)
    {
        int output = Integer.MAX_VALUE - 1;
        
        // Then we will begin our for loop to search for a pair of combination
        // that will sum up closest to target
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                for(int k=j+1;k<nums.length;k++)
                {
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    int newSumDiff = Math.abs(sum - target);
                    int oldSumDiff = Math.abs(output - target);
                    
                    // Our new sum is less even closer to the target than our old sum
                    // hence let's update our closest sum
                    if(newSumDiff < oldSumDiff)
                    {
                        output = sum;
                    }
                }
            }
        }
        
        return output;
    }

}
