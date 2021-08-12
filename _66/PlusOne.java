package _66;
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int input1[] = {9};
        System.out.println(Arrays.toString(plusOne(input1)));
        
        int input2[] = {4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne(input2)));
        
        int input3[] = {1, 2, 3};
        System.out.println(Arrays.toString(plusOne(input3)));
        
        int input4[] = {0};
        System.out.println(Arrays.toString(plusOne(input4)));
    }
    
    public static int[] plusOne(int[] digits) {
        // Break this problem into two parts
        // first increment the last digit
        // Then the second part we will do the incrementing of the subsequent digits if it go over 10
        digits[digits.length - 1] += 1; // increment the first place
        
        boolean previous10 = false;
        
        // Then we will loop over
        for(int i=digits.length-1;i>=0;i--) {
            if(previous10) {
                digits[i] += 1;
                previous10 = false;
            }
            if(digits[i] == 10) {
                digits[i] = 0;
                previous10 = true;
            }
            
        }
        
        if((previous10  && digits[0] == 0)) {
            // We need to expand the array to include one  more digit
            int output[] = new int[digits.length + 1];
            digits[0] = 0;
            for(int j=output.length-1;j>=0;j--) {
                if(j == 0) {
                    output[0] = 1;
                }
                else {
                    output[j] = digits[j-1];
                }
            }
            return output;
        }
        
        return digits;
    }
}
