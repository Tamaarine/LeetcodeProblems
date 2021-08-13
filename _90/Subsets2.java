package _90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        int nums1[] = {1, 1, 2, 2};
        System.out.println(subsetsWithDup(nums1));
        
        int nums2[] = {0, 0, 0, 1};
        System.out.println(subsetsWithDup(nums2));
    }
    
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    public static void backtrack(List<List<Integer>> result, List<Integer> temp, int nums[], int start) {
        if(!result.contains(temp)) {
            result.add(new ArrayList<Integer>(temp));
        }

        for(int i=start;i<nums.length;i++) {
            temp.add(nums[i]);
            backtrack(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
