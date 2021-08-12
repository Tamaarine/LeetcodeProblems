package _57;
import java.util.Arrays;

public class InsertInterval {
    public static void main(String[] args) {
        int input1[][] = {{1, 3}, {6, 9}};
        int input2[] = {2, 5};
        System.out.println(Arrays.deepToString(insert(input1, input2)));
        
        int input3[][] = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int input4[] = {4, 8};
        System.out.println(Arrays.deepToString(insert(input3, input4)));
        
        int input5[][] = {};
        int input6[] = {5, 6};
        System.out.println(Arrays.deepToString(insert(input5, input6)));
    }
    
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        // Insert the new interval first then we will merge
        int output[][] = new int[intervals.length + 1][2];
        
        // Since intervals is already sorted we just need to find the place to insert newInterval
        int index = 0;
        int counterForInterval = 0;

        // Just find the place to insert the new interval is fine
        while(index < intervals.length && intervals[index][0] < newInterval[0]) {
            index++;
        }
        
        // Now we found where we need to insert it we pick all the elements before the index
        int i = 0;
        while(i < output.length) {
            if(i == index) {
                output[i] = newInterval;
            }
            else {
                output[i] = intervals[counterForInterval];
                counterForInterval++;
            }
            i++;
        }
        
        // Merge, already sorted. One iteration to merge
        int returnSize = 1;
        
        for(int k=1;k<output.length;k++) {
            int prevInterval[] = output[returnSize - 1];
            int prevLo = prevInterval[0];
            int prevHi = prevInterval[1];
            
            int currentInterval[] = output[k];
            
            // Overlaps then we will merge
            if(currentInterval[0] >= prevLo && currentInterval[0] <= prevHi || currentInterval[1] >= prevLo && currentInterval[1] <= prevHi) {
                prevInterval[1] = Math.max(prevHi, currentInterval[1]);
            }
            // Within the previous interval's range just continue
            else if(currentInterval[0] >= prevLo && currentInterval[0] <= prevHi && currentInterval[1] >= prevLo && currentInterval[1] <= prevHi) {
                continue;
            }
            else {
                output[returnSize] = currentInterval;
                returnSize++;
            }
        }
        
        int finalOutput[][] = new int[returnSize][2];
        
        for(int k=0;k<returnSize;k++) {
            finalOutput[k] = output[k];
        }
            
        return finalOutput;
    }
}
