package _5;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("racecar"));
        System.out.println(longestPalindrome("ac"));
    }
    
    public static String longestPalindrome(String s) {
        if(s.length() <= 1) {
            return s;
        }
        String max = "";
        for(int i=0;i<s.length();i++) {
            for(int j=i;j<s.length();j++) {
                String sub = s.substring(i, j + 1);
                if(isPalindrome(sub) && sub.length() > max.length()) {
                    max = sub;
                }
            }
        }
        return max;
    }
    
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sbreverse = new StringBuilder(sb).reverse();
        if(sb.compareTo(sbreverse) == 0) {
            return true;   
        }
        else {
            return false;
        }
    }
    
}