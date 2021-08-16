package _169;

import java.util.HashMap;

public class MajorityElement {
    
    public static void main(String[] args) {
        int nums1[] = {3, 2, 3};
        System.out.println(majorityElement(nums1));
        
        int nums2[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums2));
    }
    
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        } 
        for(int key : map.keySet()) {
            if(map.get(key) > nums.length / 2) return key; 
        }
        return 0; // will always exist
    }
    
    public static int majorityElementMoore(int[] nums) { 
        // https://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html
        // Uses the idea of the Moore majority vote algorithm
        int count = 0;
        int majority = nums[0];
        
        for(int i : nums) {
            if(count == 0) {
                count = 1;
                majority = i;
            }
            else if(majority == i) {
                count++;
            }
            else {
                count--;
            }
        }
        return majority;
    }
    
    
}
