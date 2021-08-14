package _151;

public class ReverseWord {
    public static void main(String[] args) {
        System.out.println(reverseWordsBetter("hello world"));
        System.out.println(reverseWordsBetter("hello world you look great"));
        System.out.println(reverseWordsBetter("hello"));
        System.out.println(reverseWordsBetter("hello    "));
        System.out.println(reverseWordsBetter("         hello    mordekaiser    "));
        System.out.println("hello world you are nice".lastIndexOf("e", 4));
    }
    
    public static String reverseWordsBetter(String s) {
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i) != ' ') {
                end = i; // Mark the end of this word
                i = s.lastIndexOf(" ", end); // Move i to the space that is before the word
                sb.append(s.substring(i + 1, end + 1)).append(" ");           
            }
        }
        return sb.toString().trim();
    }
    
    public static String reverseWords(String s) {
        String output = "";
        
        String temp = "";
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) != ' ') {
                temp += s.charAt(i);
            }
            else if(temp.length() != 0) {
                output = " " + temp + output;
                temp = "";
            }
        }
        
        if(output.length() == 0 && temp.length() != 0) return temp;
        
        if(temp.length() == 0) {
            return output.substring(1);
        }
        else {
            return temp + output;
        }
    }
}
