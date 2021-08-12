package Amazon;
public class MinimalMaximum {
    public static void main(String[] args) {
        int arr1[][] = {{7, 5, 3},
                        {2, 0 , 9},
                        {4, 5, 4}
        };
        System.out.println(getMinMax(arr1));
    }
    
    public static int getMinMax(int grid [][]) {
        // We will be building a dp array
        // as we go through each of the element of the array
        int dp[][] = new int[grid.length][grid[0].length];
        
        // Iterate through the grid element by element
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(i == 0 && j == 0) {
                    // the first element, cannot avoid it
                    dp[i][j] = grid[i][j];
                    continue; // then we continue, don't need to do anything else
                }
                
                // however, if it is not the first element, then we have to figure out
                // the minimal between the element to the top and the current, if top exist
                int top = i > 0 ? dp[i - 1][j] : Integer.MIN_VALUE; // if it doesn't exist, make it the smallest
                
                // by making it the smallest then when we compare it to find the maximum we won't be choosing that value
                int left = j > 0 ? dp[i][j - 1] : Integer.MIN_VALUE;
                
                // Then current dp array value will be equal to
                // the max between the min between current grid value and top, and the min between current grid value and left
                dp[i][j] = Math.max(Math.min(top, grid[i][j]), Math.min(left, grid[i][j]));
            }
        }
        // then we know that the maximum of the minimal of each path is propagated to the end
        // to the last element
        return dp[grid.length -1][dp[0].length - 1];
    }
}
