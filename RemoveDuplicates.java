public class RemoveDuplicates
{
    public static void main(String [] args)
    {
        
    }
    
    public static int removeDuplicates(int nums[])
    {
        // If the given array is already empty then we just have to return 0
        if(nums.length == 0)
        {
            return 0;
        }
        
        // If we are here then that means the array is not empty hence we have
        // to do our algorithm to go through the array and remove the duplicates
        int i = 0; // The slow pointer
        
        // This for loop will be going through the array to 
        for(int j=0;j<nums.length;j++)
        {
            // If the slow pointer is not equal to the fast pointer then
            // that means we have found the next different element hence we can swap
            if(nums[i] != nums[j])
            {
                // We replace the element after the slow pointer with j, the not duplicated element
                nums[i + 1] = nums[j];
                
                // Then we increment the i index
                i++;
            }
        }
        
        // The length of the array is just i + 1
        return i + 1;
    }
}
