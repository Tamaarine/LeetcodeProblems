

public class LongestCommonPrefix
{
    public static void main(String [] args)
    {
        String strs1[] = {"Leetcode", "Leez", "Lychee", "Loser"};
        System.out.println(longestCommonPrefix(strs1));
        
        String strs2[] = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs2));
        
        String strs3[] = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs3));
        
        String strs4[] = {};
        System.out.println(longestCommonPrefix(strs4));
        
    }
    
    public static String longestCommonPrefix(String[] strs) 
    {
        // Size of the array is 0 hence there is no commonprefix just return ""
        if(strs.length == 0)
        {
            return "";
        }
        
        // However if we are here then that means there is elements in the array therefore we will begin our search
        // for a common prefix among the String/Strings
        // We assume the output is the first String utnil we proven otherwise through the for loop
        String output = strs[0];
        
        for(String s:strs)
        {
            output = findCommonPrefix(output, s);
        }
        
        return output;
    }
    
    /**
     * This function find the common prefixes between two Strings
     * 
     * @param str1
     * @param str2
     * @return 
     */
    public static String findCommonPrefix(String str1, String str2)
    {
        String output = "";
        
        // Only go up to the length of str2 because str2 is smaller 
        if(str1.length() > str2.length())
        {
            for(int i=0;i<str2.length();i++)
            {
                char str1Char = str1.charAt(i);
                char str2Char = str2.charAt(i);
                
                if(str1Char == str2Char)
                {
                    output += str1Char;
                }
                else
                {
                    return output;
                }
            }
        }
        // Only go up to the length of str1 because str1 is smaller or they are equal in length
        else
        {
            for(int i=0;i<str1.length();i++)
            {
                char str1Char = str1.charAt(i);
                char str2Char = str2.charAt(i);
                
                if(str1Char == str2Char)
                {
                    output += str1Char;
                }
                else
                {
                    return output;
                }
            }
        }
        
        return output;
        
    }
}
