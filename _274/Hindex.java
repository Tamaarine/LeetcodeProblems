package _274;

import java.util.Arrays;

public class Hindex {
    public static void main(String[] args) {
        
    }
    
    public int hIndex(int[] citations) {
        // Bucket sorting algorithm scheme
        int buckets[] = new int[citations.length + 1];
        int n = citations.length;
        
        // Just putting the frequency of each number into the buckets
        // any element greater than the length of citations will be put into the last bucket
        // because the valid value for h-index is from [1 - length of citations]
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            }
            else {
                buckets[c]++;
            }
        }
        
        // Then this is just magic
        // Go backward cuz we want the greatest h-itndex
        int count = 0;
        for(int i=buckets.length - 1;i>=0;i--) {
            count += buckets[i];
            if(count >= i) {
                // Okay here is why it works count will be keeping
                // track the number of paper that has more than i citations
                // For example if count is 40, and we are at i=3, that means there are 40 paper 
                // that has at least 3 citations
                // Next, if the count is greater than or equal to i, then that means we have found our solutions
                // h-index
                // There is enough paper that is cited more than i times, and if it is equal we have exactly that many
                // We don't haev to worry about N - h condition because it is implcitly satisfied. If we have 9 elements in total
                // we currently have 5 paper that is  cited more than 4 times, the other 4 on the left side are definitely cited less
                // than 4 times and only have 4 of them which satisfied N - h
                
                // If count is greater than i, that's fine like say we have 5 paper that is cited more than 4 times, we can
                // pretend that we move one of the paper to the left side, so we really only have 4 paper cited more than or equal to 4 times
                // the other 9 - 4 = 5 papers are cited less than or equal to 4 times.
                
                // Which is why count >= i
                return i;
            }
        }
        return 0;
    }
}
