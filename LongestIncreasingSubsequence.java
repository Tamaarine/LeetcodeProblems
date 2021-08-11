public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        
    }
    
    public static int longest(int nums[]) {
        // The idea for this problem is to make an array that is the same
        // size as nums. Then put in the first element, we assume the first element
        // is always valid. Until we are doing the shifts later
        // Then iterate through the rest of the nums element.
        // Keep a separate counter for the temp array as that will tell us where to insert
        // the next element
        // Then if nums[i] is greater than counter - 1, that means it is increasing so we can
        // insert it
        // However, if it is less, then we will have to find the appropriate place to insert
        // the element using a binary search. Even though the temp array might not end up being
        // always increasing but the length will always be guaranteed to be correct
        int temp[] = new int[nums.length];
        temp[0] = nums[0];
        int length = 1;
        
        for(int i=1;i<nums.length;i++) {
            if(nums[i] > temp[length - 1]) {
                // we can insert it no problem
                temp[length++] = nums[i];
            }
            else {
                // then we have to find the correct position to insert it through binary search
                int position = search(temp, 0, length - 1, nums[i]);
                nums[position] = nums[i];
            }
        }
        
        return length;
    }
    
    public static int search(int nums[], int low, int high, int x) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > x) {
                // mid is too big, so we have to decrease high
                high = mid - 1;
            }
            else if(nums[mid] == x) {
                // same element, then we will return mid that's where we will insert it
                return mid;
            }
            else {
                // <= nums[mid] then we will increase low because it is too small
                low = mid + 1;
            }
        }
        return low; // just have to return low 
    }
}