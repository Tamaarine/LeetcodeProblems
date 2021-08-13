package _17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class LetterCombinationPhone {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        backtrack(result, "", digits, 0, map);
        return result;
    }
    
    
    public static void backtrack(List<String> result, String temp, String digits, int start, HashMap<Integer, String> map) {
        if(temp.length() == digits.length()) {
            result.add(temp);
        }
        else if(start == digits.length()) {
            return;
        }
        else {
            String mappedString = map.get(digits.charAt(start) - '0');
            for(int i=0;i<mappedString.length();i++) {
                temp += mappedString.charAt(i);
                backtrack(result, temp, digits, start + 1, map);
                temp = temp.substring(0, temp.length() - 1);
            }
        }
    }
}
