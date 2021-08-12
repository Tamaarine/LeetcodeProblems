package _219;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(nums1, 3));
        
        int nums2[] = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(nums2, 1));
        
        int nums3[] = {1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(nums3, 2));
    }
    
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // Not optimized
        // for(int i=0;i<nums.length;i++) {
        //     for(int j=i+1;j<nums.length;j++) {
        //         if(nums[i] == nums[j] && Math.abs(i - j) <= k) return true;
        //     }
        // }
        // return false;
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
            if(!map.containsKey(nums[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
            else {
                map.get(nums[i]).add(i);
            }
        }
        System.out.println(map);
        // Then do a for loop to check if there is a pair that exist such that i - j <= k
        for(List<Integer> l : map.values()) {
            int slow = 0;
            for(int fast=1;fast<l.size();fast++) {
                if(Math.abs(l.get(slow) - l.get(fast)) <= k)
                {
                    return true;  
                } 
                else {
                    // move slow up 
                    slow = fast;
                }
            }
        }
        return false;
    }
}
