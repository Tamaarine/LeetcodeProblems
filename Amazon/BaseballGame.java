package Amazon;

import java.util.ArrayList;
import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String inputs[] = {"10", "20", "X", "+"};
        System.out.println(baseballGame(inputs));
        
        String inputs2[] = {"10", "20", "Z", "30", "+"};
        System.out.println(baseballGame(inputs2));
        
        String inputs3[] = {"10", "20", "+", "+", "+", "Z"};
        System.out.println(baseballGame(inputs3));
    }
    
    public static int baseballGame(String inputs[]) {
        // this will be used for keeping track all of the scores that occured
        Stack<Integer> scores = new Stack<>();
        scores.push(0);
        
        // Use for outputting the final score
        int output = 0;
        
        for(String s: inputs) {
            System.out.println("Current score is " + output);
            // we only double the previous score if it isn't empty
            if(s.equals("X") && !scores.isEmpty()) {
                // If it is a X, then we double what we have score last
                int prev = scores.peek();
                scores.add(prev * 2);
                output += prev * 2;
            }
            else if(s.equals("+")) {
                // Add the previous two scores need to make sure it has at least two elements
                int first = -1;
                int second = -1;
                
                // Pop two elements if it exists
                if(!scores.isEmpty()) {
                    first = scores.pop();
                    
                    if(!scores.isEmpty()) {
                        second = scores.pop();
                        
                        scores.push(second);
                        scores.push(first);
                        scores.push(first + second);
                        output += first + second;
                    }
                    else {
                        // Can only pop once
                        // push back first, and push another first back because is like 0 + first = first
                        scores.push(first);
                        scores.push(first);
                        output += first;
                    }
                }
                // if it is else then i guess we push a 0
                else {
                    scores.push(0);
                }
            }
            else if(s.equals("Z")) {
                // throw away the last score
                if(!scores.isEmpty()) {
                    int popped = scores.pop();
                    output -= popped;
                }
            }
            else {
                // Is an integer
                int valueToAdd = Integer.parseInt(s);
                
                scores.add(valueToAdd);
                output += valueToAdd;
            }
        }
        return output;
    }
}
