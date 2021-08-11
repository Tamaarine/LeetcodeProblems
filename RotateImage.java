public class RotateImage
{
    public static void main(String[] args)
    {
        int mat1[][] = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        rotate(mat1);
        print2DArray(mat1);
        
    }
    
    
    
    
    /**
     * Given a n x n 2D matrix that represent an image
     * rotate the image by 90 degrees clockwise
     * do it in place without allocating another 2D matrix to do the rotation
     * 
     * Transpose then revserse will give rotation effect
     * 
     * @param matrix 
     */
    public static void rotate(int matrix[][])
    {
        // First step is to transpose the matrix in place
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                // Non-diagonal we will swap
                if(i < j)
                {
                    int temp = matrix[i][j];
                    
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                    
                }
            }
        }
        
        print2DArray(matrix);
        
        // Then we just have to reverse each array of the 2D matrix
        for(int element[]: matrix)
        {
            for(int i=0;i<=(element.length - 1)/2;i++)
            {
                int temp = element[i];

                element[i] = element[element.length-1-i];
                element[element.length-1-i] = temp;
           }
        }
        
        // Then we are done
    }
    
    public static void print2DArray(int nums[][])
    {
        for(int r=0;r<nums.length;r++)
        {
            for(int c=0;c<nums.length;c++)
            {
                System.out.print(nums[r][c] + ", ");
            }
            System.out.println();
        }
    }
}