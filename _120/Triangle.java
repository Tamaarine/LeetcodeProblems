import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(new ArrayList<>(Arrays.asList(2)));
        triangle1.add(new ArrayList<>(Arrays.asList(3,4)));
        triangle1.add(new ArrayList<>(Arrays.asList(6,5,7)));
        triangle1.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(minimumTotal(triangle1));
    }
    
    public static int minimumTotal(List<List<Integer>> triangle) {
        // This problem we don't need recursion at all
        // We will be using the last element of the triangle as our DP array
        List<Integer> dp = triangle.get(triangle.size() - 1);
        
        // The basic idea is just to for each element we find the minpath sum and propagate the
        // minpath sum to each element up the tree
        // For the last row, we don't have to do anything because the minpath sum is the element itself
        // So we will start at the row before the last row
        
        // We don't need any additional memory because we can just use the last row to store our results
        // Go through each of the row starting at the second to last row
        for(int i=triangle.size()-2;i>=0;i--) {
            List<Integer> currentRow = triangle.get(i);
            
            // Go through each element of that row
            for(int v=0;v<currentRow.size();v++) {
                // Find the min sum for each of the current element, and setting it into dp because we won't
                // look back again for the next element
                int sum = Math.min(currentRow.get(v) + dp.get(v), currentRow.get(v) + dp.get(v + 1));
                dp.remove(v);
                dp.add(v, sum);
                System.out.println(dp);
            }
        }
        
        // This is genius, then we just have to return dp[0] since it has the min path sum
        return dp.get(0);
    }
    
}
