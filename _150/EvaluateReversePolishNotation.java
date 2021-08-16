package _150;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    
    public static void main(String[] args) {
        String[] input1 = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(input1));
        
        String[] input2 = {"4","13","5","/","+"};
        System.out.println(evalRPN(input2));
        
        String[] input3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(input3));
    }
    
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String s : tokens) {
            if(s.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                
                int result = num2 / num1;
                stack.push(result);
            }
            else if(s.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                
                int result = num2 + num1;
                stack.push(result);
            }
            else if(s.equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                
                int result = num2 - num1;
                stack.push(result);
            }
            else if(s.equals("*")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                
                int result = num2 * num1;
                stack.push(result);
            }
            else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}
