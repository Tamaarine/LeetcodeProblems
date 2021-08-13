package _78;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int nums1[] = {1, 2, 3};
        System.out.println(subsets(nums1));
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, nums);
        return result;
    }
    
    public static void backtrack(List<List<Integer>> result, List<Integer> temp, int start, int nums[]) {
        result.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++) {
            temp.add(nums[i]);
            backtrack(result, temp, i + 1, nums);
            temp.remove(temp.size() - 1);   
        }
    }
    
    
    
    
}
