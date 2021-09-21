package _482;

public class LicenseFormat {
    
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("---", 2));
        System.out.println(licenseKeyFormatting("helloworld", 3));
        System.out.println(licenseKeyFormatting("this-dfa-af-vc-asd", 3));
    }
    
    public static String licenseKeyFormatting(String s, int k) {
        // Use StringBuilder because it is more efficient
        StringBuilder sb = new StringBuilder();
        
        // Turn it all into upper case
        s = s.toUpperCase();
        
        // COunt the number of dashes in the string
        int dashes = 0;
        for(char z : s.toCharArray()) {
            if(z == '-') dashes++;
        }
        
        // Tells us how many characters we are formatting
        int leftOver = s.length() - dashes;
        int first_sec = leftOver % k; // gives us how many characters we have for the beginning
        
        // If leftover is 0 that means all the characters are dashes hence return empty string
        if(leftOver == 0) return "";
        
        // gives us the option to do the first section separately
        boolean isFirstTime = true;
        
        // if first_sec have no characters, then we don't have to do any first time string concatenation
        if(first_sec == 0) isFirstTime = false;
        
        int count = 0;
        
        for(char z : s.toCharArray()) {
            if(z != '-') {
                sb.append(z);
                count++;
            }
            
            // Not firsttime anymore, append a dash reset count 
            if(!isFirstTime && count == k) {
                sb.append('-');
                count = 0;
            }
            else if(isFirstTime && count == first_sec) {
                sb.append('-');
                count = 0;
                isFirstTime = false;
            }
        }
        
        // delete the last extra dashes that we appended 
        sb = sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }
}
