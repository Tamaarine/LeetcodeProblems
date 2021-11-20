package _39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Will be using a recursive function to solve this problem
        // basically the recursive function will have couple arugments
        // the lists which is a list of list that will be storing our actual output
        // a temp list, which will be keeping track of the working solution to a list of integers which adds up to target
        // remain which tells us how much value we are still missing
        // and start which is the index that tells us in the recursive call where to start checking for the values
        
        List<List<Integer>> output = new ArrayList<>();
        
        // start is 0 because we are starting at index 0
        backtrack(output, new ArrayList<>(), target, 0, candidates);
        
        // Just have to return the output after we are done with the recursion
        return output;
        
    }
    
    public static List<List<Integer>> backtrack(List<List<Integer>> output, int candidates[], int remain) {
        
    }
}
