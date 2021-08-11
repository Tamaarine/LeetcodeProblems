public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinaryBetter("11", "1"));
        System.out.println(addBinaryBetter("1010", "1011"));
    }
    
    public static String addBinaryBetter(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        
        String output = "";
        
        while(i >=0 || j >= 0) {
            int sum = carry;
            if(i >= 0) {
                sum += a.charAt(i--) - '0';
            }     
            if(j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            
            int digit = sum % 2;
            carry = sum / 2;
            output += digit;
        }
        
        if(carry != 0) {
            output += carry;
        }
        return reverse(output);
    }
    
    public static String addBinary(String a, String b) {
        int i = 0;
        
        String aReverse = reverse(a);
        String bReverse = reverse(b);
        
        String shortest;
        String longest;
        
        if(aReverse.length() > bReverse.length()) {
            shortest = bReverse;
            longest = aReverse;
        }
        else {
            shortest = aReverse;
            longest = bReverse;
        }
        
        boolean carry = false;
        
        String output = "";
        
        while(i < shortest.length()) {
            int aChar = aReverse.charAt(i) - 48;
            int bChar = bReverse.charAt(i) - 48;
            
            if(carry) {
                int result = aChar + bChar + 1;
                
                if(result == 1) {
                    output = "1" + output;
                    carry = false;
                }
                else if(result == 2) {
                    output = "0" + output;
                }
                else if(result == 3) {
                    output = "1" + output;
                }
            }
            else {
                int result = aChar + bChar;
                
                if(result == 0) {
                    output = "0" + output;
                }
                else if(result == 1) {
                    output = "1" + output;
                }
                else if(result == 2) {
                    output = "0" + output;
                    carry = true;
                }
            }
            i++;
        }
        
        if(a.length() == b.length()) {
            if(carry) {
                output = "1" + output;
                return output;
            }   
        }
        else {
            while(i < longest.length()) {
                int aChar = longest.charAt(i) - 48;
                if(carry) {
                    int result = aChar + 1;
                    
                    if(result == 1) {
                        output = "1" + output;
                        carry = false;
                    }
                    else {
                        output = "0" + output;
                        carry = true;
                    }
                }
                else {
                    if(aChar == 0) {
                        output = "0" + output;
                    }
                    else {
                        output = "1" + output;
                    }
                }
                
                i++;
            }
            
            if(carry) {
                output = "1" + output;
            }
        }
        return output;
    }
    
    public static String reverse(String a) {
        String output = "";
        for(int i=0;i<a.length();i++) {
            output = a.charAt(i) + output;
        }
        return output;
    }
}
