package _22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthese {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(8));
    }
    
    public static List<String> generateParenthesis(int n) {
        // The idea of using the backtrack is to keep track of the number of open
        // and close parentheses, you add as many open parenthese as you can
        // then when open equals to n, that indicates that you should start
        // adding the close parentheses and when the length of that string reaches
        // 2 * n you will add it to output
        
        // If open reaches n, then you start adding close. You only add enough close
        // parenthese to cover the amount of open you have. Never exceeding it
        // because then it will be invalid parenthese expression
        List<String> output = new ArrayList<>();
        backtrack(output, "", 0, 0, n);
        return output;
    }
    
    public static void backtrack(List<String> output, String workingStr, int open, int close, int n) {
        if(workingStr.length() == 2 * n) {
            output.add(workingStr);
        }
        
        // Add as much open parenthese as you can initially before you add close
        if(open < n) {
            backtrack(output, workingStr + "(", open + 1, close, n);
        }
        if(close < open) {
            backtrack(output, workingStr + ")", open, close + 1, n);
        }
    }
    
    
}
