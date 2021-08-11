public class LongestConsecutiveString {
    public static void main(String[] args) {
        System.out.println(maxLengthString("baaabbabbb"));
        System.out.println(maxLengthString("babba"));
        System.out.println(maxLengthString("aaaaaa"));
        System.out.println(amazonPart("baccc", 2));
        System.out.println(amazonPart("xxxxzaz", 3));
        
    }
    
    public static int maxLengthString(String str) {
        int max = 0; // assume that 0 is the longest until proven
        
        if(str.length() < 3) {
            return str.length();
        }
        
        // once you encounter 3 same characters, then you can just subtract 3 compare to the
        // previous one to see which one is longer. Keep doing that until you reach the end of the string
        for(int i=0;i<str.length();i++) {
            char prevChar = str.charAt(i);
            int count = 1; // starts with one

            // inner for loop starts after the i-th letter
            for(int j=i+1;j<str.length();j++) {
                char currentChar = str.charAt(j);
                
                if(currentChar == prevChar) {
                    count++;
                }
                else {
                    prevChar = currentChar;
                    count = 1;
                }
                
                // Hit over 3, need to stop and stop the for loop
                if(count == 3) {
                    int currentLength = j - i; // calculate the length of substring without including the 3 repeated letters
                    
                    if(currentLength > max) {
                        max = currentLength;
                    }
                    break;
                }
                // however, if j reached the end without the previous break case
                // then to the end of the string is our longest substring :)
                else if(j == str.length() - 1) {
                    int currentLength = j - i + 1;
                    
                    if(currentLength > max) {
                        max = currentLength;
                    }
                }
            }
        }
        return max;
    }
    
    public static String amazonPart(String originalLabel, int charLimit) {
        String output = "";
        int count[] = new int[26];
        
        // increment the count for each of the letters
        for(int i=0;i<originalLabel.length();i++) {
            count[originalLabel.charAt(i) - 'a'] += 1;
        }
        
        // then we go backwards
        for(int i=25;i>=0;i--) {
            // if it is greater than the charLimit
            if(count[i] > charLimit) {
                // append what you can
                output += Character.toString(i + 'a').repeat(charLimit);
                count[i] -= charLimit;   // subtract away
                
                // Then use a while loop to find the next prioirty element starting at
                // index i - 1
                int j = i - 1;
                while(j >= 0) {
                    // Found a suitable next prioirty element, append it once
                    if(count[j] > 0) {
                        output += Character.toString(j + 'a');
                        count[j] -= 1;  // just subtract away once
                        break;   // then break after because we found a suitable element
                    }
                    else if(j == 0 && count[j] == 0) {
                        // Done searching didn't found anything, done with appending
                        return output;
                    }
                    j--;
                }
                i++;
            }
            // non zero but less than charLimit just append everything and move on
            else if(count[i] <= charLimit && count[i] > 0) {
                output += Character.toString(i + 'a').repeat(count[i]);
                count[i] = 0; // set it to 0 since we used all
            }
            else {
                // don't do anyting if it is equal to 0
            }
        }
        
        return output;
        
    }
}
