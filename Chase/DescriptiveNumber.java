package Chase;

import java.util.HashMap;

public class DescriptiveNumber {
    public static void main(String[] args) {
        for(int i=0;i<100000000;i++) {
            if(isDescriptiveNumber(i)) {
                System.out.println(i);
            }
        }
    }
    
    // Given an integer determine whether or not the number is self descriptive or not
    // descriptive in terms of describing the number of digits in its corresponding index
    
    public static boolean isDescriptiveNumber(long n) {
        HashMap<Integer, Integer> map = new HashMap<>(); // map the number to its occurence in n
        
        String strN = n + "";
        for(int i=0;i<strN.length();i++) {
            // for loop that basically counts the occurence of each digit
            int intDigit = strN.charAt(i) - '0';
            map.put(intDigit, map.getOrDefault(intDigit, 0) + 1);
        }
        
        for(int i=0;i<strN.length();i++) {
            int intDigit = strN.charAt(i) - '0';
            if(intDigit != map.getOrDefault(i, 0)) {
                return false;
            }
        }
        return true;
    }
}
