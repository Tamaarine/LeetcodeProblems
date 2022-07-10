package _61;

public class RotateList {
    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        
        a.next = b;
        b.next = c;
        
        int k = 4;
        
        for (int i=1;i<=k;i++) {
            ListNode rot = rotateRight(a, i);
            ListNode ptr = a;
            while (ptr != null) {
                System.out.print(ptr + ", ");
                ptr = ptr.next;
            }
            
            System.out.println();
            
            ptr = rot;
            while (ptr != null) {
                System.out.print(ptr + ", ");
                ptr = ptr.next;
            }
            
            System.out.println("\n----");
        }
        
    }
    
    static class ListNode {
        private int v;
        private ListNode next;
        public ListNode() {
            v = 0;
        }
        public ListNode(int in) {
            v = in;
        }
        
        public String toString() {
            return "" + v;
        }
    }
    
    public static ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        int size = 0; 
        ListNode ptr = head;
        while (ptr != null) {
            size ++;
            ptr = ptr.next;
        }
        k = k % size;
        
        if (k == 0 || head == null) return head;
        
        ListNode rotated = new ListNode(-1); // Dummy node first
        ptr = head; // Set it to be head again
        while (count < size - k) {
            ptr = ptr.next; 
            count ++;
        }
        
        count = 0;
        ListNode rotatedPtr = rotated;
        while (count < size) {
            rotatedPtr.next = new ListNode(ptr.v);
            rotatedPtr = rotatedPtr.next;
            count ++;
            ptr = ptr.next;
            
            if (ptr == null) {
                ptr = head;
            }
        }
        
        return rotated.next;
    }
    
}