package _349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionTwoArray {
    public static void main(String[] args) {
        int nums1[] = {1, 2, 2, 1};
        int nums2[] = {2, 2};
        System.out.println(Arrays.toString(intersectionBetter(nums1, nums2)));
        
        int nums3[] = {4, 9, 5};
        int nums4[] = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersectionBetter(nums3, nums4)));
    }
    
    public static int[] intersectionBetter(int nums1[], int nums2[]) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for(int i : nums1) set1.add(i);
        for(int i : nums2) {
            if(set1.contains(i)) set2.add(i);
        }
        
        int output[];
        
        if(set1.size() > set2.size()) {
            output = new int[set2.size()];
        }
        else {
            output = new int[set1.size()];
        }
        
        int counter = 0;
        output = new int[set2.size()];
        for(int i : set2) {
            output[counter++] = i;
        }
        return output;
    }
    
    public static int[] intersection(int[] nums1, int[] nums2) {
        // Sort both arrays first
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        ArrayList<Integer> output = new ArrayList<Integer>();        
        
        int first = 0;
        
        while(first < nums1.length) {
            if(binarySearch(nums2, nums1[first])) {
                // If found add to output
                output.add(nums1[first]);
            }
            
            // Move on to the next element
            first++;
            
            // Then skip all the duplicates regardless we found it in nums2 or not
            while(first < nums1.length && nums1[first] == nums1[first - 1]) {
                first++;
            }
            
            
        }
        
        return output.stream().mapToInt(i -> i).toArray();
    }
    
    public static boolean binarySearch(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return true;
            }
            else if(target > nums[mid]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
    
    
}
