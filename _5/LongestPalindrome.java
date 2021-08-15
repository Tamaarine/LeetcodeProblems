package _5;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
    }
    
    public static String longestPalindrome(String s) {
        String max = "";
        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<s.length();j++) {
                String sub = s.substring(i, j + 1);
                if(isPalindrome(s.substring(i, j + 1)) && )
            }
        }
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