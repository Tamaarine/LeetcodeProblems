public class SmallestDivisor {
    public static void main(String[] args) {
        System.out.println(findSmallestDivisor("bcdbcdbcdbcd", "bcdbcd"));
        System.out.println(findSmallestDivisor("bcdbcdbcd", "bcdbcd"));
    }
    
    public static int findSmallestDivisor(String planConfig, String displayStr) {
        if(canDivide(planConfig, displayStr)) {
            // now here we will be looping over displayStr to find the smallest string which can divide
            // both planConfig and displayStr
            int min = Integer.MAX_VALUE;
            
            for(int i=0;i<displayStr.length();i++) {
                String currentSubString = displayStr.substring(0, i + 1);
                
                if(canDivide(planConfig, currentSubString) && canDivide(displayStr, currentSubString)) {
                    // we only update if the length of currentSubString is less than min
                    min = currentSubString.length() < min ? currentSubString.length() : min;
                }
            }
            
            return min;
        }
        else {
            // didn't pass the first test so return -1
            return -1;
        }
    }
    
    public static boolean canDivide(String input1, String input2) {
        // Check whether or not input1 String is able to be divide by input2 
        // by concanating it multiple times
        String workingStr = "";
        
        // keep adding t string until it is equal to input1 or length is greater
        while(workingStr.length() < input1.length() && !workingStr.equals(input1)) {
            workingStr += input2;
        }
        
        if(workingStr.equals(input1)) {
            return true;
        }
        else {
            return false;
        }
    }
}