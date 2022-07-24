package _128;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence inst = new LongestConsecutiveSequence();
        
        int arr1[] = {100, 4, 200, 1, 3, 2};
        System.out.println(inst.longestConsecutive(arr1));
        
        int arr2[] = {101, 1, 102, 103, 104};
        System.out.println(inst.longestConsecutive(arr2));
        
        int arr3[] = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(inst.longestConsecutive(arr3));
        
        int arr4[] = {};
        System.out.println(inst.longestConsecutive(arr4));
        
        int arr5[] = {-3, -2, -1, 0};
        System.out.println(inst.longestConsecutive(arr5));
    }
    
    public int longestConsecutive(int nums[]) {
        // Since the brute force method doesn't work we will have to improve it by
        // adding in HashMap into it. We will still be keeping in the idea of 
        // checking the long consecutive sequence by iterating through the element
        // However, this is the change, we will be storing each of the elemnt into a HashSet
        // this way it will allow us to do a look up in O(1) time for the element
        
        if (nums.length == 0) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        // Add each integer into the HashSet so we can check it in O(1) time
        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 1;
        
        // Then go through the array again
        for (int num : nums) {
            // We will only continue to check the conseuctive sequence
            // if it doesn't contain num - 1 in the array, because it is pointless
            // if it does contain the predecessor since it always smaller
            int currentLonest = 1;
            if (!set.contains(num - 1)) {
                // If we are here then that means num is the start of the consecutive sequence, never
                // in the middle
                // Like [3, 2, 45, 1]
                // We will never go in here with 3, 2 beacuse 3 can be reached from 2
                // 2 can be reached from 1
                
                // Okay now we will be checking the rest of the sequence using the set
                // same procedure as trail 1 
                while(set.contains(num + 1)) {
                    currentLonest += 1;
                    num += 1;
                }
                
                longest = currentLonest > longest ? currentLonest : longest;
            }
        }
        
        return longest;
    }
    
    public int longestConsecutiveTrial1(int[] nums) {
        // Let's do a first attempt on this using a very brute force method
        // Always think brute force before going into optimizing it
        // The brute force method will simply be iterating over each element
        // And for each element, find the longest conseuctive sequence it can be made
        // by searching through the array 
        
        // But this function will take O(n^3), the most inner for loop might run O(n^2) time
        // we want O(n) run time
        
        // EX
        // [100, 1, 3, 2]
        // 100 it found none
        // 1 it found 3
        // 2 found 2
        // 3 found none
        
        if (nums.length == 0) return 0;
        
        int longest = 1; 
        
        for (int i=0;i<nums.length;i++) {
            int currentElement = nums[i];
            int currentLongest = 1;
            currentElement += 1; 
            
            for(int j=0;j<nums.length;j++) {
                // If it matches the next conseuctive element, add 1 to currElement and currLongest
                // reset the current for loop index to -1, so when it goes out it will become 0 again
                if (currentElement == nums[j]) {
                    currentElement += 1;
                    currentLongest += 1;
                    j = -1;
                }
            }
            
            longest = currentLongest > longest ? currentLongest : longest;
        }
        
        return longest;
    }
}
