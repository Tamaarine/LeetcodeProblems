import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        Integer nums1[] = {2,3,1,3,3};
        nextPermutation(nums1);
        System.out.println(Arrays.asList(nums1));
    }
    
    public static void nextPermutation(Integer nums[]) {
        // The idea for this problem is to find the first element that starts to descent
        // say at index j
        
        // Then we look at j - 1, which is the element before the first element that starts to descent
        // we look to the right of [j - 1] to find the smallest element that is bigger than [j - 1]
        // and swap, because we want the next lexicographically bigger element, hence we need to 
        // get the element that is just bigger
        
        // Finally, after swapping we sort the right side of j - 1 in ascending order because we want the
        // smallest lexicographically permutation
        int j = nums.length - 1;
        
        while(j > 0 && nums[j] <= nums[j - 1]) {
            j--;
        }
        
        
        if(j > 0) {
            // After finding j we locate j - 1, and starting from j we find the smallest element
            // that is greater than [j - 1]
            int smallestGreaterIndex = nums.length - 1;
            
            // The way we find the smallest greatest element than j -1
            // we search from the right side again, because if we start at j it will disurpt
            // the descending ordering if there are the same elements, it won't be descending order
            // anymore if we just take the first element right than the right most element
            while(nums[j - 1] >= nums[smallestGreaterIndex]) {
                smallestGreaterIndex--;
            }
            
            // We perform the swap
            int temp = nums[j - 1];
            nums[j - 1] = nums[smallestGreaterIndex];
            nums[smallestGreaterIndex] = temp;
            System.out.println(smallestGreaterIndex);
        }
        
        // Then we can reverse the array to the right of j - 1
        int left = j;
        int right = nums.length - 1;
        
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    
}
