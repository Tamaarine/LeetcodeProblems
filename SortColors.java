import java.util.Arrays;
import java.util.HashMap;

public class SortColors {
    public static void main(String[] args) {
        int nums1[] = {2, 0, 2, 1, 1, 0};
        sortColors(nums1);
        System.out.println(Arrays.toString(nums1));
    }
    
    public static void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        
        for(int i=0;i<nums.length;i++) {
            int key = nums[i];
            int currentVal = map.get(key);
            map.put(key, currentVal + 1);
        }
        
        for(int i=0;i<nums.length;i++) {
            if(i < map.get(0)) {
                nums[i] = 0;
            }
            else if(i < map.get(0) + map.get(1)) {
                nums[i] = 1;
            }
            else {
                nums[i] = 2;
            }
        }
    }
}
