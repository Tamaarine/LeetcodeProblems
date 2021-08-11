public class StrStr
{
    public static void main(String [] args)
    {
        System.out.println(strStr("Hello", "k"));
    }
    
    /**
     * Basically implement indexOf in Java
     * return 0 if the searching String is empty
     * 
     * @param haystack
     * @param needle
     * @return 
     */
    public static int strStr(String haystack, String needle)
    {
        int length = needle.length();

        if(length == 0)
        {
            return 0;
        }
        
        // Just brute force do it I suppose
        for(int i=0;i<=haystack.length() - length;i++)
        {
            String substr = haystack.substring(i, i + length);
            
            if(substr.equals(needle))
            {
                return i;
            }
        }
        
        // If somehow we reached here that means the for loop didn't find the needle
        // hence we just return -1 here
        return -1;
    }
}
