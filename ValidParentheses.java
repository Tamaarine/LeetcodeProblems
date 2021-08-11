import java.util.Stack;

public class ValidParentheses
{
    public static void main(String [] args)
    {
        System.out.println(isValid("([])"));
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("{[]}"));
    }
    
    public static boolean isValid(String s)
    {
        // The int will be keeping added and subtracted based on
        // the bracket that it encounters
        int shouldBeZero = 0;
        
        Stack s1 = new Stack();
        
        for(int i=0;i<s.length();i++)
        {
            // Get the current char
            char charAtI = s.charAt(i);
            
            if(charAtI == '(' || charAtI == '{' || charAtI == '[')
            {
                // Push it onto the stack
                s1.push(charAtI);
            }
            else
            {
                if(s1.empty())
                {
                    return false;
                }
                char peek = (char)s1.peek();
                
                if((peek == '(' && charAtI == ')') || (peek == '[' && charAtI == ']') || (peek == '{' &&  charAtI == '}'))
                {
                    s1.pop();
                }
            }
        }
        
        if(s1.empty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
