public class CountAndSay
{
    public static void main(String[] args) 
    {
        System.out.println(countAndSay(10));
    }
    
    public static String countAndSay(int n)
    {
        if(n == 1)
        {  
            return "1";
        }
        else
        {
            String before = countAndSay(n - 1);
            String output = "";
            
            char prevChar = before.charAt(0);
            int counter = 0;
            
            for(int i=0;i<before.length();i++)
            {
                char currChar = before.charAt(i);
                
                if(prevChar != currChar)
                {
                    // Here we concatenate the information we have about the previous character
                    output += counter + "" + prevChar;
                    
                    prevChar = currChar;
                    counter = 1;
                }
                else if(prevChar == currChar)
                {
                    counter++;
                }
                
                if(i == before.length() - 1)
                {
                    // Add it in because it is the last one
                    output += counter + "" + currChar;
                }
                
            }
            return output;
        }
    }
}
