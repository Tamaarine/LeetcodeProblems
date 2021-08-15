package _24;

public class SwapNodes {
    static class ListNode {
        private int val;
        private ListNode next;
        
        public ListNode(int val) {
            this.val = val;
            next = null; 
        }
        
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        
        public String toString() {
            String output = "";
            ListNode currNode = this;
            while(currNode != null) {
                output += currNode.val + " ";
                currNode = currNode.next;
            }
            return output;
        }
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(head);
        
        System.out.println(swapPairs(head));
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null) {
            return head;
        }
        
        return helper(head);
    }
    
    public static ListNode helper(ListNode node) {
        if(node.next == null) {
            // Base case no more swapping
            return node;
        }
        else if(node.next.next == null) {
            // Swap and return the node swapped
            ListNode nextNode = node.next;
            
            nextNode.next = node;
            node.next = null;
            return nextNode; // return the swapped node
        }
        else {
            ListNode need = helper(node.next.next);
            ListNode nextNode = node.next;
            
            nextNode.next = node;
            node.next = need;
            
            return nextNode;
        }
    }
}
