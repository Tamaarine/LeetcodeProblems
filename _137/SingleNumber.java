package _137;

public class SingleNumber {
    
    public static void main(String[] args) {
        int nums1[] = {2, 2, 2, 4, 3, 3, 3};
        System.out.println(singleNumber(nums1));
    }
    
    public static int singleNumber(int[] nums) {
        // This approach uses bitwise operation to do the counting
        // Make a truth table, since you need to count to 3
        // the table becomes like this
        // A B and C are 32 bit integer, but we are only looking at one bit
        // for now, since the counting idea carries over to 32 bit
        // C is the input bit, and we need to make SOP form for both output A and B
        // A  B  C  A output   B output
        // 0  0  0      0          0
        // 0  0  1      0          1                           
        // 0  1  0      0          1      
        // 0  1  1      1          0        
        // 1  0  0      1          0      
        // 1  0  1      0          0      
        
        // We make a SOP form for A output and B output
        // A = A'BC + AB'C'
        // B = A'B'C + A'BC'
        
        // Then that is our formula for counting basically
        // the element that only appears once will be only counted once
        // and that will be the result
        // For example if the given array is [2, 2, 2, 4]
        // A and B will initially start with 0 0
        // Then seeing first 2 will become 0 2, where 2 is the B
        // then 2 0 after second 2
        // and then goes back to 0 0 after third 2
        // And finally seeing the last 4 will become 0 4
        
        // A more complex example will be [2, 2, 2, 4, 3, 3, 3]
        // The transformation goes from 0 0 -> 0 2
        // 2 0 -> 0 0 -> 0 4 -> 0 7 -> 3 7 -> 0 4 
        // Then you would A | B to return the final answer
        
        int a = 0;
        int b = 0;
        for(int c : nums) {
            int tempA = (~a&b&c) | (a&~b&~c);
            b = (~a&~b&c) | (~a&b&~c);
            a = tempA;
        }
        return a | b;
    }
}
