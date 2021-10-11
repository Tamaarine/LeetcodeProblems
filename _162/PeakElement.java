package _162;

public class PeakElement {
    public static void main(String[] args) {
        int input1[] = {-2147483648,-2147483647};
        System.out.println(findPeakElementBS(input1));
        
    }
    
    // The obvious approach which is to do a linear scan and search for the local max element
    public static int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        
        int output = 0;
        for(int i=0;i<nums.length;i++) {
            if(i == 0) {
                if(nums[i] > nums[i + 1]) {
                    output = 0;
                }
            }
            else if(i == nums.length - 1) {
                if(nums[i] > nums[i - 1]) {
                    output = i;
                }
            }
            else {
                if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    output = i;
                }
            }
        }
        return output;
    }
    
    public static int findPeakElementBS(int nums[]) {
        if(nums.length == 1) {
            return 0;
        }
        
        // Use binary search to find the peak element
        // The idea is to look at the middle element, if the middle element
        // is a local max, then boom you can just return the answer, however,
        // if it is not a local max. And is in a ascending slope, then you know that the local max is to the 
        // right, else descending slope it is to the left
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            int leftElement = mid - 1 >= left ? nums[mid - 1] : Integer.MIN_VALUE;
            int rightElement = mid + 1 <= right ? nums[mid + 1] : Integer.MIN_VALUE;
            
            if(nums[mid] > leftElement && nums[mid] > rightElement) {
                return mid;
            }
            else if(nums[mid] >= leftElement && nums[mid] <= rightElement) {
                // In the right half
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return -1;
        
        
        
    }
}
