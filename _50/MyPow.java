package _50;

public class MyPow {
    public static double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        else if(n == Integer.MIN_VALUE) {
            return myPow(1/x * 1/x, -n - 1);
        }
        else if(n < 0) {
            return myPow(1/x, -n);
        }
        
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2); 
    }
    
    public static double myPowBetter(double x, int n) {
        if(n == 0) {
            return 1;
        }
        else if(n == Integer.MIN_VALUE) {
            return myPowBetter(1/x * 1/x, -n - 1);
        }
        else if(n < 0) {
            return myPowBetter(1/x, -n);
        }
        
        double pow = myPowBetter(x, n / 2);
        
        if(n % 2 == 0) {
            return pow * pow;
        }
        else {
            return x * pow * pow;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE - 1);
        System.out.println(myPow(1, -2147483648));
    }
}
