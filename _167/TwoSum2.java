package _167;


public class TwoSum2
{
    public static void main(String [] args)
    {
        int arr1[] = {2,7,11,15};
        printIntArray(twoSum(arr1, 9));
        
        int arr2[] = {2,3,4};
        printIntArray(twoSum(arr2, 6));
        
        int arr3[] = {-1,0};
        printIntArray(twoSum(arr3, -1));
    }
    
    /**
     * Given a sorted array find the two index of element that sum up to target
     * keep in mind that the returned index is not zero based
     * 
     * @param numbers
     * @param target
     * @return 
     */
    public static int[] twoSum(int[] numbers, int target)
    {
        int output[] = new int[2];
        
        int l = 0;
        int r = numbers.length - 1;
        
        while(l < r)
        {
            int sum = numbers[l] + numbers[r];
            
            // The sum of left and right is too small then we have to increment
            // the left side
            if(sum < target)
            {
                l++;
            }
            // The sum of left and right is too big then we have to decrement
            // the right side
            else if(sum > target)
            {
                r--;
            }
            // The sum of left and right is just target hence we can return output
            else
            {
                output[0] = l + 1;
                output[1] = r + 1;
                
                return output;
            }
        }
        
        return output;
    }
    
    public static void printIntArray(int arr[])
    {
        for(int i:arr)
        {
            System.out.print(i + ", ");
        }
        
        System.out.println("");
    }
}