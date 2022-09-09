package _191;

public class NumberOf1Bits {
    public static void main(String[] args) {
        NumberOf1Bits inst = new NumberOf1Bits();
        System.out.println(inst.hammingWeight(342));
        
        System.out.println(inst.hammingWeight(0));
        
        System.out.println(inst.hammingWeight(1));
        
        System.out.println(inst.hammingWeight(-3));
        
    }
    
    
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for(int i=0;i<32;i++) {
            if ((n & mask) != 0) {
                count += 1;
            }
            mask <<= 1;            
        }
        return count;
    }
}
