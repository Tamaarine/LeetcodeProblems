public class LongestStringOnlyVowels {
    public static void main(String[] args) {
        System.out.println(longestVowelString("letsgosomewhere"));
    }
    
    public static int longestVowelString(String input) {
        // The idea is to use two variables
        // start and end respectively. start represent the end of the vowel for the first
        // continous vowel string
        // while end represent the start of the vowel for the last continous vowel string minus 1. Just before it
        // if start == len(string) - 1, this means that the entire string is a vowel string
        // otherwise we will look between start and end including end. 
        int start = 0, end = input.length() - 1;
        
        // Get us to the end of the vowel for the first continous vowel string + 1
        while(start < input.length() && isVowel(input.charAt(start))) {
            start ++;
        }
        
        // the entire string is vowel
        if(start == input.length()) return input.length();
        
        // get us to the start of the vowel for the last continous vowel string - 1
        while(end >= 0 && isVowel(input.charAt(end))) {
            end --;
        }
        
        int max = 0;
        int temp = 0;
        // then we just need to find the largest vowel string in between
        for(int i=start;i<=end;i++) {
            // should be including both indexes because it doens't include the vowel strings
            if(isVowel(input.charAt(i))) {
                temp ++;
            }
            else {
                // reset max if we encountered a non-vowel
                temp = 0;
            }
            
            if(temp > max) {
                max = temp;
            }
        }
        System.out.println(start + " " + end);
        // then finally the longest vowel string is just how many characters is before start, how many
        // after end, and plus max
        return input.length() - 1 - end + start + max;
    }
    
    public static boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }
}
