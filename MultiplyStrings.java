public class MultiplyStrings
{
    public static void main(String[] args)
    {
        System.out.println(multiply("10", "9"));
    }
    
    public static String multiply(String num1, String num2)
    {
        // The maximum digit that the product can have is the sum of the length of the two numbers
        int sum[] = new int[num1.length() + num2.length()];
        
        for(int i=num1.length()-1;i>=0;i--)
        {
            for(int j=num2.length()-1;j>=0;j--)
            {
                // From ascii to int
                int num1Digit = num1.charAt(i) - '0';
                int num2Digit = num2.charAt(j) - '0';
                
                int product = num1Digit * num2Digit;
                
                int newSum = sum[i + j + 1] + product;
                
                int remainder = newSum / 10;
                
                sum[i + j + 1] = newSum % 10;
                sum[i + j] = sum[i + j] + remainder;
            }
        }
        
        String output = "";
        
        for(int element: sum)
        {
            output += element;
        }
        
        int toReturnFrom = 0;
        
        for(int i=0;i<output.length();i++)
        {
            if(output.charAt(i) == '0')
            {
                toReturnFrom++;
            }
            else
            {
                break;
            }
        }
        
        if(toReturnFrom == output.length())
        {
            return "0";
        }
        else
        {
            return output.substring(toReturnFrom);
        }
    }
}
