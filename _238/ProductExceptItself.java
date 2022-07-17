package _238;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ProductExceptItself {
    public static void main(String[] args) {
        ProductExceptItself inst = new ProductExceptItself();
        
        int arr1[] = {1, 2, 3, 4};
        System.out.println(Arrays.toString(inst.productExceptSelf(arr1)));
        
        int arr2[] = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(inst.productExceptSelf(arr2)));
        
        int arr3[] = {0, -1};
        System.out.println(Arrays.toString(inst.productExceptSelf(arr3)));
        
        int arr4[] = {0, -1, 0};
        System.out.println(Arrays.toString(inst.productExceptSelf(arr4)));
        
    }
    
    
    public int[] productExceptSelfTrial1(int[] nums) {
        // This turned out didn't work when 0 is involved, because it messed up the totalProduct
        
        // Integer that represent the total product
        int totalProduct = 1;
        
        for(int i : nums) {
            if (i != 0) 
            totalProduct *= i;
        }

        int output[] = new int[nums.length];
        
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) continue;
            output[i] = totalProduct / nums[i];   
        }
        
        return output;
    }
    
    public int[] productExceptSelf(int[] nums) {
        // The second try that I'm thinking is by using prefix sum
        // Well prefix multiplication, just like prefix sum, but use multiplication instead of summing
        // If more than 1 0, then everything is 0 because the other 0 will messed up the result regardless
        int forward[] = new int[nums.length]; // Forward product
        int backward[] = new int[nums.length]; // Backward product 
        
        // First element of forward is just the first element        
        forward[0] = nums[0];
        
        // First backward element from right to left is just the rightmost element from nums
        backward[backward.length - 1] = nums[nums.length - 1];
        
        // This for loop carries out the prefix product
        // Forward is pretty simple, is just the previous forward times the current nums
        // Backward since we are doing it in one for loop, have to do some conversion
        // We start from the second element from right to left, so length - i - 1, length - i is the previous element
        for(int i=1;i<nums.length;i++) {
            forward[i] = forward[i - 1] * nums[i];
            backward[backward.length - i - 1] = backward[backward.length - i] * nums[nums.length - i - 1];
        }
        
        // The new output array
        // The left element will just backward[1]
        // Right most element is forward[-2], two elements before
        int output[] = new int[nums.length];
        output[0] = backward[1];
        output[nums.length - 1] = forward[nums.length - 2];
        
        // Then just walk through the rest of the element multiplying the left and right element for current i
        for(int i=1;i<output.length - 1;i++) {
            output[i] = forward[i - 1] * backward[i + 1];
        }
        
        System.out.println("Original " + Arrays.toString(nums));
        System.out.println("Forward " + Arrays.toString(forward));
        System.out.println("Backward " + Arrays.toString(backward));
        
        return output;
    }
}
