package _46;
import java.util.ArrayList;
import java.util.List;

public class Permutations
{
    public static void main(String[] args)
    {
        
    }
    
    public static List<List<Integer>> permute(int nums[])
    {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(output, temp, nums);
        return output;
    }
    
    public static void helper(List<List<Integer>> result, List<Integer> temp, int nums[]) {
        // base case which is when temp reaches the same
        // length as nums
        if(temp.size() == nums.length) {
            result.add(new ArrayList(temp));
            return;
        }
        
        // else we do the recursive case which is a for loop
        // we will loop through from 0 to end of the length
        // we check whether or not the current item is in the temp list
        // if not we add it and call the recursive function
        for(int i=0;i<nums.length;i++) {
            int currentInt = nums[i];
            
            // doesn't exist yet, we will add it to our temp list and recursive call
            if(temp.indexOf(currentInt) == -1) {
                temp.add(currentInt);
                helper(result, temp, nums);
                temp.remove(temp.size() - 1); // after we are done, we will remove the list
            }
        }
    }
}
