package _228;

import java.util.List;
import java.util.ArrayList;

public class SummaryRange {
    public static void main(String[] args) {
        int input1[] = {1,2,3,7,9,12};
        System.out.println(summaryRanges(input1));
        
        int input2[] = {1,2,3,4,5,6,7,8};
        System.out.println(summaryRanges(input2));
    }
    
    public static List<String> better(int nums[]) {
        List<String> output = new ArrayList<>();
        
        for(int i=0;i<nums.length;) {
            int j = i+1;
            while(j < nums.length && nums[j] == nums[j-1] + 1) j++;
            
            if(j-1 == i) output.add(nums[i] + "");
            else output.add(String.format("%d->%d", nums[i], nums[j-1]));
            
            i = j;
        }
        
        return output;
    }
    
    public static List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<>();
        if(nums.length == 0) {
            return output;
        }
        int start = 0;
        int end = 0;
        
        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[end] + 1) {
                // Add the string to our result
                if(nums[start] == nums[end]) {
                    output.add(nums[start] + "");
                    start = i;
                    end = i;
                }
                else {
                    output.add(String.format("%d->%d", nums[start], nums[end]));
                    start = i;
                    end = i;
                }
            }
            else {
                end++;
            }
        }
        
        // one more iteration
        if(nums[start] == nums[end]) {
            output.add(nums[start] + "");
        }
        else {
            output.add(String.format("%d->%d", nums[start], nums[end]));
        }
        return output;
        
    }
    
    
}
