import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        int input1[][] = {{1,3},
                          {2,6},
                        {8, 10},
                        {15, 18}};
        System.out.println(Arrays.deepToString(merge2(input1)));
                        
        // int input2[][] = {{1, 4},
        //                 {4, 5}};                
        // System.out.println(Arrays.deepToString(merge(input2)));
        
        // int input3[][] = {{1, 4},
        //                 {0, 5}};                
        // System.out.println(Arrays.deepToString(merge(input3)));
        
        // int input4[][] = {{2,3},
        //                   {4,5},
        //                 {6,7},
        //                 {8,9},
        //                 {1, 10}};
        // System.out.println(Arrays.deepToString(merge2(input4)));
    }
    
    static class IntervalComparator implements Comparator<int []> {

        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] > o2[0]) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }
    
    public static int [][] merge2(int intervals[][]) {
        // Sort the interval array first
        Arrays.sort(intervals, new IntervalComparator());
        
        int counter = 1; // Keeps track of how many interval we have collected
        int prevIndex = 0; // The previous interval we have looked
        
        for(int i=1;i<intervals.length;i++) {
            // If the current interval is within range of the previous interval
            // then we keep the previous interval the same don't increment counter
            int currentInterval[] = intervals[i];
            int prev[] = intervals[prevIndex];
            
            System.out.println(Arrays.deepToString(intervals) + " is " + Arrays.toString(prev));
            
            // Within range of the previous interval just continue
            if(currentInterval[0] >= prev[0] && currentInterval[0] <= prev[1] && currentInterval[1] >= prev[0] && currentInterval[1] <= prev[1]) {
                continue;
            }
            // Else if it overlaps, then we will update the previous interval
            else if((currentInterval[0] >= prev[0] && currentInterval[0] <= prev[1]) || (currentInterval[1] >= prev[0] && currentInterval[1] <= prev[1])) {
                // Then we merge
                prev[0] = Math.min(currentInterval[0], prev[0]);
                prev[1] = Math.max(currentInterval[1], prev[1]);
            }
            // If it doesn't overlap then we will increment counter
            else {
                // Leave the interval be and move on
                // but update the prev
                prevIndex = i;
                intervals[counter] = currentInterval;
                counter++;
            }
        }
        
        int output[][] = new int[counter][2];
        
        for(int i=0;i<output.length;i++) {
            output[i] = intervals[i];   
        }
        
        return output;
    }
    
    public static int[][] merge(int[][] intervals) {
        int output[][] = new int[intervals.length][intervals[0].length];
        
        int counter = 0; // counter for the output array, to where to insert the next element
        
        for(int i=0;i<intervals.length;i++) {
            int currentInterval[] = intervals[i];
            if(counter == 0) {
                output[counter] = currentInterval;
                counter++;
            }
            else {
                counter = mergeHelper(output, counter, currentInterval);
            }
            // System.out.println(Arrays.deepToString(output));
        }
        
        int actualOutput[][] = new int[counter][2];
        for(int i=0;i<actualOutput.length;i++) {
            actualOutput[i] = output[i];
        }
        
        return actualOutput;
    }
    
    public static int mergeHelper(int list[][], int count, int toMerge[]) {
        // This function will be helping to merge the given interval into the output list if possible
        // if not will just insert at the next index and return the the incremented count
        for(int i=0;i<count;i++) {
            int currentInterval[] = list[i];
            
            int low = currentInterval[0];
            int hi = currentInterval[1];
            
            // Able to merge by fitting toMerge inside a interval that already exist
            if(toMerge[0] >= low && toMerge[0] <= hi || toMerge[1] >= low && toMerge[1] <= hi) {
                currentInterval[0] = Math.min(low, toMerge[0]);
                currentInterval[1] = Math.max(hi, toMerge[1]);
                return count;
            }
            // Able to merge by fitting an exissting interval into toMerge's interval
            else if(low >= toMerge[0] && low <= toMerge[1] && hi >= toMerge[0] && hi <= toMerge[1]) {
                list[i] = toMerge;
                return count;
            }
        }
        
        // If we are here then it is unable to merge, hence we will just insert it to the list
        list[count] = toMerge;
        return ++count;
    }
}
