package _1071;

public class GreatestCommonDivisorString {
    public static void main(String[] args) {
        System.out.println(gcdOfStringsBetter("ABCABC", "ABC"));
        System.out.println(gcdOfStringsBetter("TAUXTAUXTAUX", "TAUXTAUX"));
    }

    public static String gcdOfStringsBetter(String str1, String str2) {
        // A better approach is to notice that if the string
        // divides both str1 and str2, then str1 + str2 is equal to str2
        // If it can divide both, then it the concatenation of those two
        // should be the same. It is the common string that when repeated
        // should end up str1 and str2 x number of times. So the string
        // that ended up should be equal if you do it str2 times first, or str1 times first
        // If they are not equal, then there is no a common string that divides both str1 and str2
        if((!(str1+str2).equals(str2+str1))) return "";

        // Then we just have to find the greatest common length between
        // the two strings, we can do so by using euclidean gcf
        int len1 = str1.length();
        int len2 = str2.length();
        
        // Find the gcd
        int gcd = gcd(len1, len2);
        return str1.substring(0, gcd);
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        int remainder = a % b;
        if(remainder == 0) {
            return b;
        }
        else {
            return gcd(b, remainder);
        }
    }



    public static String gcdOfStrings(String str1, String str2) {
        String output = "";
        StringBuilder working = new StringBuilder();
        char loopThrough[] = str1.length() > str2.length() ? str2.toCharArray() : str1.toCharArray();

        for(char c : loopThrough) {
            working = working.append(c);

            if(isDivisible(str1, working.toString()) && isDivisible(str2, working.toString()))
            {
                output = working.toString();
            }
        }
        return output;
    }

    public static boolean isDivisible(String str1, String b) {
        // Return whether or not string str1 is divisible by string b
        StringBuilder sb = new StringBuilder();

        while(sb.length() < str1.length()) {
            sb = sb.append(b);
        }

        if(sb.length() != str1.length()) return false;
        else if(sb.toString().equals(str1)) return true;
        else return false;
    }




}
