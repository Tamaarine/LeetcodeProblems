public class LargestString
{
    public static void main(String [] args)
    {
        String s1 = "aabbacd";
        System.out.println(getLargestString(s1, 1));
                
        String s2 = "aahrfawfhialraf";
        System.out.println(getLargestString(s2, 1));
        
        String s3 = "ggabcccdef";
        System.out.println(getLargestString(s3, 2));
        
        String s4 = "happybirthdayy";
        System.out.println(getLargestString(s4, 2));
        
    }
    
    /**
     * Given a String label return a new String by rearranging the original string
     * and deleting the chars as needed. Return the alphabetically-largest string that
     * can be made respecting the limit as to how many consecutive chars can be the same
     * represented by k
     * 
     * Alphabetically largest is defined as reverse alphabetical order so
     * b is greater than a
     * c is greater than b and so on
     * z, y, x... c, b, a
     * 
     * Test Cases:
     * aahrfawfhialraf, 1 -> wrlrihfhfafa
     * aabbacd, 1 -> dcbaba
     * ggabcccdef, 2 -> ggabcccdef
     * happybirthdayy, 2 -> yytyrppihhdbaa
     * 
     * @param originalLabel
     * @param charLimit
     * @return 
     */
    public static String getLargestString(String originalLabel, int charLimit)
    {
        // Sort the String first in reverse alphabetical order
        for(int i=0;i<originalLabel.length();i++)
        {
            int swapIndex = i;
            for(int j=i+1;j<originalLabel.length();j++)
            {
                char currentChar = originalLabel.charAt(swapIndex);
                char currentCharJ = originalLabel.charAt(j);

                if(currentChar < currentCharJ)
                {
                    // Update swapIndex because it is a letter that comes later
                    swapIndex = j;
                }
            }
            
            // We only swap if we found a valid swapping letter
            if(swapIndex > i)
            {
                // Outside here we have which letter we need to swap with letter at i with swapIndex
                // Since String is immutable we have to make a brand new String
                char swapAtI = originalLabel.charAt(i);
                char swapAtJ = originalLabel.charAt(swapIndex);

                String beforeI = originalLabel.substring(0, i);
                String betweenIJ = originalLabel.substring(i + 1, swapIndex);
                String afterJ = originalLabel.substring(swapIndex + 1);

                originalLabel = beforeI + swapAtJ + betweenIJ + swapAtI + afterJ;
            }
        }
        
        System.out.println("The sorted String is " + originalLabel);
        // Now originalLabel is sorted in decreasing alphabetical order
        // we can proceed with our algorithm
        
        // We need a counter variable to keep track of how many particular letter
        // we have counted so far
        // We also need a char variable to keep track of which was the previous letter
        int count = 0;
        char prevLetter = 0;
        
        for(int i=0;i<originalLabel.length();i++)
        {
            char currentLetter = originalLabel.charAt(i);
            
            // If the currentLetter is not equal to the previous letter then we 
            // make count equal to 1, and make prevLetter equal to currentLetter
            if(currentLetter != prevLetter)
            {
                count = 1;
                prevLetter = currentLetter;
            }
            // Else if they are equal then we increment count
            else
            {
                count++;
            }
            
            // Now here we will perform check whether or not our counter
            // is greater than k. If it is greater than k 
            // then we have to do a search throughout to find the next alphabtical letter
            // and do a swap
            if(count > charLimit)
            {
                // Assume itself is the swappableLetter until proven
                int swappableLetter = i;
                
                // Now because we have crossed the consecutive char limit we have
                // to do a linear search to find the index of the next swappable letter
                // since it is sorted already it is very easy to look for the next letter
                for(int j=i+1;j<originalLabel.length();j++)
                {
                    char letterAtJ = originalLabel.charAt(j);
                    char letterToAvoid = originalLabel.charAt(i);
                    
                    // If it is a different letter great, we update swappableLetter and break
                    if(letterAtJ != letterToAvoid)
                    {
                        swappableLetter = j;
                        break;
                    }
                }
                
                // If we are out here then swappableLetter is either i or an actual
                // index to a letter that we can switch.
                //If it is equal to i, then game over we just return the String up until i
                // because no replacement can be found
                if(swappableLetter == i)
                {
                    return originalLabel.substring(0, i);
                }
                else
                {
                    // If we are here then that means there is a letter that is indeed
                    // swappable hence let's swap it
                    char charAtI = originalLabel.charAt(i);
                    char swapping = originalLabel.charAt(swappableLetter);
                    
                    String beforeString = originalLabel.substring(0, i);
                    String betweenString = originalLabel.substring(i + 1, swappableLetter);
                    String afterString = originalLabel.substring(swappableLetter + 1);
                    
                    // Then we combine and update originalLabel
                    originalLabel = beforeString + swapping + betweenString + charAtI + afterString;
                    
                    // Then we also have to update prev to swapping
                    prevLetter = swapping;
                }
            }
            // If it is not greater than char then we will keep on going to the next iteration
                
            
            
        }
        
        return originalLabel;
    }
    
}