public class SearchInsert
{
    public static void main(String[] args) 
    {
        int arr1[] = {1,3,5,6};
        System.out.println(searchInsert(arr1, 5));
        
        int arr2[] = {1,3,5,6};
        System.out.println(searchInsert(arr2, 2));
        
        int arr3[] = {1,3,5,6};
        System.out.println(searchInsert(arr3, 7));
        
        int arr4[] = {1,3,5,6};
        System.out.println(searchInsert(arr4, 0));
        
        int arr5[] = {1};
        System.out.println(searchInsert(arr5, 0));
        
    }
    
    public static int searchInsert(int nums[], int target)
    {
        int insert = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            // If the target is found then just return it and be done
            if(nums[i] == target)
            {
                return i;
            }
            
            // However if the target is not found then we have to increment our insert
            if(nums[i] < target)
            {
                insert = i + 1;
            }
        }
        
        // If we are here then we have to return insert because target is not found
        return insert;
    }
}