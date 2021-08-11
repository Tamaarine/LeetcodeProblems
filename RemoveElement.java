public class RemoveElement
{
    public static void main(String [] args)
    {
        System.out.println("Worked");
    }
    
    /**
     * Given an array of ints and an int value remove all the instances
     * of that value in-place and return the new length
     * 
     * Hint: Use the two pointer method
     * 
     * @param nums
     * @return 
     */
    public static int removeElement(int nums[], int val)
    {
        // Since we will be doing it through the two pointer way we have to check
        // if the array is empty first
        if(nums.length == 0)
        {
            return 0;
        }
        
        // If we are here then we are sure that the array is at least more than one element
        int i = 0; // This is the slow pointer
        
        // j will be the fast pointer that traverse through the array
        for(int j=0;j<nums.length;j++)
        {
            // If the fast pointer is not equal to the value we are removing
            // then we will move it to the element after the i-th element
            if(nums[j] != val)
            {
                nums[i + 1] = nums[j];
                
                // Increment i as well
                i++;
            }
        }
        
        return i + 1;
    }
}
