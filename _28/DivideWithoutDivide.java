package _28;
public class DivideWithoutDivide
{
    public static void main(String[] args)
    {
        System.out.println(divide(Integer.MIN_VALUE,-1));
        System.out.println(-Integer.MIN_VALUE);
    }
    
    public static int divide(int dividend, int divisor)
    {
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        
        int quotient = 0;
        
        if(dividend == Integer.MIN_VALUE && (divisor == -1 || divisor == 1))
        {
            return Integer.MAX_VALUE;
        }
        
        while(a >= b)
        {
            a -= b;
            
            quotient++;
        }
        
        boolean diffSign = ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0));
        
        if(diffSign)
        {
            quotient = -quotient;
        }
        
        return quotient;
    }
}
