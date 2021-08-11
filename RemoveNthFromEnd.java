public class RemoveNthFromEnd
{
    public static void main(String[] args) 
    {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(5);
//        ListNode node3 = new ListNode(69);
//        ListNode node4 = new ListNode(59);
//        ListNode node5 = new ListNode(77);
        
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        
        ListNode currNode = node1;
        
        while(currNode != null)
        {
            System.out.println(currNode.val);
            currNode = currNode.next;
        }
        System.out.println("-----------");
        
        // Remove 2
        currNode = removeNthFromEndOnepass(node1, 2);
        printList(currNode);
        
        
        
    }
    
    public static ListNode removeNthFromEnd(ListNode head, int n)
    {
        // Let's figure out the size of the list first
        int size = 0;
        
        ListNode currNode = head;
        
        while(currNode != null)
        {
            size++;
            
            currNode = currNode.next;
        }
        
        // Which index of ListNode we removed can be figured out by subtracting
        // size with n
        int indexToRemove = size - n;
        
        // We will use this variable to keep track of which index we are at currently
        int counter = 0;
        
        // We are going to traverse through the list again
        currNode = head;
        ListNode prevNode = null; // We also need a Node to keep track of the previous Node
        
        while(currNode != null)
        {
            // Special case when the head is removed we just return the head's next
            if(counter == indexToRemove && indexToRemove == 0)
            {
                return head.next;
            }
            // If it is other indexes that we are removing we have to take the prev's next
            // and point that to currNode's next
            else if(counter == indexToRemove)
            {
                prevNode.next = currNode.next;
            }
            
            // Now if we are here then that means the index didn't match hence we have to
            // increment our pointers. prevNode point to currNode and currNode become currNode.next
            prevNode = currNode;
            currNode = currNode.next;
            
            // Increment our counter as well
            counter++;
        }
        
        return head;
    }
    
    public static ListNode removeNthFromEndOnepass(ListNode head, int n)
    {
        ListNode dummyNode = new ListNode(0);
        
        dummyNode.next = head;
        
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        
        for(int i=0; i<=n;i++)
        {
            fast = fast.next;
        }
        
        while(fast != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return dummyNode.next;
    }

    
    public static void printList(ListNode list)
    {
        while(list != null)
        {
            System.out.println(list.val);
            list = list.next;
        }
    }
    
    public static class ListNode
    {
        int val;
        ListNode next;
        
        public ListNode(int val)
        {
            this.val = val;
        }
        
        public ListNode(int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }
    }
}
