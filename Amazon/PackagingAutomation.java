package Amazon;

import java.util.Arrays;

public class PackagingAutomation {

    public static void main(String[] args)
    {
        int arr[] = {1, 1, 1, 1};
        System.out.println(packagingAutomation(arr));
    }
    
    public static int packagingAutomation(int arr[]) {
        // The idea for this problem is simple
        // first sort the arr, so it is ascending order
        // then the first item has to be one, so just set it to 1
        // then all the following adjacent elements must have differences
        // less than or equal to 1, meaning adjacent numbers must be the same
        // or only one greater
        // just compare whether or not the current element is greater than the previous
        // if it is, then just make it to + 1 of that value
        // otherwise we know it is the same since we sorted them in ascending order
        // so leave it as it is. Done
        
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++) {
            if(i == 0) {
                arr[0] = 1;
                continue;
            }
            
            if(arr[i] > arr[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }
}
