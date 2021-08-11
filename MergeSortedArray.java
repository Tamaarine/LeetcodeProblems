import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        
    }
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Need an extra array to copy from nums1
        int temp[] = new int[m];
        
        for(int i=0;i<m;i++) {
            temp[i] = nums1[i];
        }
        
        // Then we can start picking off the elements
        int i = 0;
        int j = 0;
        int counter = 0;
        while(i < m || j < n) {
            if(i < m && j < n) {
                if(temp[i] > nums2[j]) {
                    nums1[counter] = nums2[j];
                    j++;
                }
                else {
                    nums1[counter] = temp[i];
                    i++;                  
                }
            }
            else if(i < m) {
                nums1[counter] = temp[i];
                i++;
            }
            else {
                nums1[counter] = nums2[j];
                j++;
            }
            counter++;
        }
    }
}
