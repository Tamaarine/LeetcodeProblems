package _58;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWordBetter("Hello Worl"));
        System.out.println(lengthOfLastWordBetter("Hell"));
        System.out.println(lengthOfLastWordBetter("hello ok"));
        System.out.println(lengthOfLastWordBetter("compare this haha"));
        System.out.println(lengthOfLastWordBetter("MORDEKAISER"));
        System.out.println(lengthOfLastWordBetter("MORDEKAISER          "));
        System.out.println(lengthOfLastWordBetter("            MORDEKAISER          "));
        System.out.println(lengthOfLastWordBetter("M O R D E K A I S E R"));
    }
    
    public static int lengthOfLastWordBetter(String s) {
        // Think of this problem backward, find the last word from the back
        int size = 0;
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i) != ' ') {
                size++;
            }
            else if(size !=0) {
                return size;
            }
        }
        return size;
    }
    
    public static int lengthOfLastWord(String s) {
        int temp = 0;
        int length = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == ' ' && length != 0) {
                temp = length;
                length = 0;
            }
            else if(s.charAt(i) != ' ') {
                length++;
            }
        }
        if(length == 0) {
            return temp;
        }
        else {
            return length;
        }
    }
}
