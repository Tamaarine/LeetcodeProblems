public class SearchRange
{
    public static void main(String[] args)
    {
        int arr1[] = {5,7,7,8,8,10};
        printArray(searchRange(arr1, 8));
        
        int arr2[] = {5,7,7,8,8,10};
        printArray(searchRange(arr2, 6));
        
        int arr3[] = {};
        printArray(searchRange(arr3, 0));
        
    }
    
    /**
     * Given an array of intergers nums sorted in ascending order
     * find the starting and ending position of a gien target value
     * If the target is not found in the array return [-1, -1]
     * 
     * @param nums
     * @param target
     * @return 
     */
    public static int[] searchRange(int nums[], int target)
    {
        int left = 0;
        int right = nums.length - 1;
        
        int output[] = {-1, -1};
        
        // Keep moving until you hit the target we are looking for
        // or if left hits length
        while(left < nums.length && nums[left] != target)
        {
            left++;
        }
        
        if(left == nums.length)
        {
            return output;
        }
        
        // However if we are here then we will move the right pointer until we
        // hit the last element
        while(right >= 0 && nums[right] != target)
        {
            right--;
        }
        
        output[0] = left;
        output[1] = right;
        
        return output;
    }
    
    public static void printArray(int arr[])
    {
        for(int i:arr)
        {
            System.out.print(i + " ,");
        }
        
        System.out.println("");
    }
}
