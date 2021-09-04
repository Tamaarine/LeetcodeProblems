package _204;

public class CountPrime {
    
    public static void main(String[] args) {
        System.out.println(countPrimes(499979));
    }
    
    public static int countPrimes(int n) {
        // Use the sieve of eratosthenes. Use o(n) of extra space
        // go up to only sqrt(n) to mark off the multiples
        // If the number is multiple of 2, 3, 4 
        boolean mark[] = new boolean[n];
        
        int counter = 0;
        for(int i=2;i*i<n;i++) {
            if(!mark[i]) {
                int v = i;
                while(v * i < n) {
                    mark[v * i] = true;
                    v++;
                }
            }
        }
        
        for(int i=2;i<n;i++) {
            if(!mark[i]) counter++;
        }
        return counter;
    }
}
