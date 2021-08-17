package _189;

import java.util.Arrays;
import java.util.HashMap;


public class RotateArray {
    
    public static void main(String[] args) {
        // int nums1[] = {1, 2, 3};
        // System.out.println(Arrays.toString(nums1));
        // rotateBetter(nums1, 4);
        // System.out.println(Arrays.toString(nums1));
        
        // int nums2[] = {221, 20};
        // System.out.println(Arrays.toString(nums2));
        // rotateBetter(nums2, 1);
        // System.out.println(Arrays.toString(nums2));
        
        int nums3[] = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(nums3));
        rotateBetter(nums3, 3);
        System.out.println(Arrays.toString(nums3));
        
        // int nums4[] = {-1,-100,3,99};
        // System.out.println(Arrays.toString(nums4));
        // rotate(nums4, 2);
        // System.out.println(Arrays.toString(nums4));
        
        
    }
    
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        // Maps the index of the original array to the place the index where it suppose to go
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
            map.put(i, (i + k) % nums.length);
        }        
        
        // Make a copy of the original array
        int copy[] = nums.clone();
        
        for(int key : map.keySet()) {
            nums[map.get(key)] = copy[key];
        }
    }
    
    public static void rotateBetter(int nums[], int k) {
        k = k % nums.length; // simplify k 
        
        // The idea is to reverse the list first
        // then reverse the first k-element, and the later length - k element
        // that will give us the rotated answer
        // Reverse the list first
        if(k != 0) {
            if(nums.length <= 1) {
                return;
            }
            if(nums.length == 2) {
                int temp = nums[1];
                nums[1] = nums[0];
                nums[0] = temp;
            }
            
            // Then we will reverse the first k-element 
            // and then the later length - k elemenet
            reverseArray(nums, 0, k - 1);
            reverseArray(nums, k, nums.length - 1);
            
        }
    }
    
    public static void reverseArray(int nums[], int start, int end) {
        int mid = start + (end - start) / 2; // inclusive when swapping
        
        for(int i=start;i<=mid;i++) {
            int temp = nums[i];
            nums[i] = nums[start + end - i];
            nums[start + end - i] = temp;    
        }
    }
    
}
