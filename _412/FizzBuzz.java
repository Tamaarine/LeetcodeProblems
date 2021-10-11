package _412;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        ArrayList<String> ans = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            if(i % 3 != 0 && i % 5 != 0){
                ans.add(Integer.toString(i));
                continue;
            }
            
            String s = "";
            if(i % 3 == 0){
                s += "Fizz";
            }
            if(i % 5 == 0){
                s += "Buzz";
            }
            ans.add(s);
        }
        return ans;
    }
}
