public class SplitPrimeSegments {
    public static void main(String[] args) {
        
        
    }
    
    public static int splitPrimeSegments(String input, int count) {
        // We will be doing it recursively checking every single segment one
        // by one
        return 0;
    }
    
    public static boolean isPrime(int num) {
        // check if a number is prime or not
        for(int i=1;i * i < num;i++) {
            if(num % i == 0) {
                return false;
            }
        }
        
        // If we are here, need to make sure that num is greater than 1
        // because 1 is not a prime
        return num > 1 ? true : false;
    }
}
