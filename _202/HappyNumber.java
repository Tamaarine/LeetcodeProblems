package _202;

import java.util.HashMap;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }
    
    public static boolean isHappy(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(n, 1); // once
        map.put(1, 0); // initial value
        int temp = n;
        
        while(map.get(temp) != 2 && map.get(1) == 0) {
            temp = squareSum(temp);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        
        if(map.get(1) == 0) {
            return false;
        }
        else {
            return true;
        }
        
    }
    
    public static int squareSum(int n) {
        int output = 0;
        while(n > 0) {
            output += (n % 10) * (n % 10); 
            n /= 10;
        }
        return output;
    }
}
