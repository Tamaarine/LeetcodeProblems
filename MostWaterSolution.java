

public class MostWaterSolution
{
    public static void main(String [] args)
    {
        int arr1[] = {1,2,3,4,5};
        System.out.println(maxArea(arr1));
        
        int arr2[] = {1,1};
        System.out.println(maxArea(arr2));
        
        int arr3[] = {4,3,2,1,4};
        System.out.println(maxArea(arr3));
        
        int arr4[] = {1,2,1};
        System.out.println(maxArea(arr4));
    }
    
    
    /**
     * Given n non-negative integers a1, a2, ..., an where each represents a point
     * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the
     * line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis
     * forms a container such that the container contains the most water
     * 
     * @param height
     *  The list of ais
     * @return Returns the most water that can be formed by two vertical lines
     */
    public static int maxArea(int[] height) 
    {
        int output = 0;
        
        // We obviously need a nested for loop to traverse through the arrays
        for(int i=0;i<height.length;i++)
        {
            for(int j=i+1;j<height.length;j++)
            {
                // First we need to compare which of the two height do we take either 
                // the one at i or at j
                int heightI = height[i];
                int heightJ = height[j];
                
                int area = 0;
                
                // heightI is larger hence we will use heightJ's height to do the multiplication
                if(heightI > heightJ)
                {
                    area = heightJ * (j - i);
                }
                // If we are here then that means heightJ's height is higher hence we use ehightI to do the multiplication
                else
                {
                    area = heightI * (j - i);
                }
                
                // Then out here we must compare whether or not the area is larger than
                // what we have so far
                if(area > output)
                {
                    output = area;
                }
            }
        }
        
        return output;
    }
}