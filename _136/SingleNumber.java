package _136;

public class SingleNumber {
    
    public static void main(String[] args) {
        int nums1[] = {1, 1, 2, 3, 3};
        System.out.println(singleNumber(nums1));
    }
    
    public static int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }
}
