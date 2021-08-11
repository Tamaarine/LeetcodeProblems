
import java.util.Arrays;

public class Ropes {
    public static void main(String[] args) {
        int arr1[] = {8, 4, 6, 12};
        System.out.println(ropes(arr1));
        
        int arr2[] = {20, 4, 8, 2};
        System.out.println(ropes(arr2));
        
        int arr3[] = {2, 2, 3, 3};
        System.out.println(ropes(arr3));
        
        int arr4[] = {1, 2, 5, 10, 35, 89};
        System.out.println(ropes(arr4));
    }
    
    public static int ropes(int arr[]) {
        // Sort the array
        // then just add up pairs of ropes,
        Arrays.sort(arr);
        
        // Go backward and just sum it up
        int sum = 0;
        for(int i=0;i<arr.length-1;i++) {
            int first = arr[i];
            int second = arr[i + 1];
            
            arr[i + 1] = first + second;
            
            Arrays.sort(arr);
            
            sum += first + second;
        }
        return sum;
    }
}