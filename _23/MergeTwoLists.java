package _23;
public class MergeTwoLists
{
    public static void main(String [] args)
    {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;
        
        ListNode input1[] = {node1, node4, node7};
        ListNode output1 = mergeKLists(input1);
        printNode(output1);
        
        ListNode input2[] = {};
        ListNode output2 = mergeKLists(input2);
        printNode(output2);
        
        ListNode node9 = null;
        ListNode input3[] = {node9};
        ListNode output3 = mergeKLists(input3);
        printNode(output3);
        
//        ListNode output = mergeTwoLists(node1, node4);
        
//        printNode(output);
        
    }
    
    public static void printNode(ListNode nodes)
    {
        while(nodes != null)
        {
            System.out.println(nodes.val);
            
            nodes = nodes.next;
        }
    }
    
    /**
     * This function merge two sorted linked lists and return it as a sorted list
     * the list should be created it by splicing together the nodes of the first
     * two lists. In other words the new merged list should be created using
     * the nodes of the two given lists
     * 
     * @param l1
     * @param l2
     * @return 
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode output = null;
        ListNode currPointer = null;
        
        if(l1 == null)
        {
            return l2;
        }
        else if(l2 == null)
        {
            return l1;
        }
        else
        {
            // We will be doing a while loop, while the both list's pointer
            // is not yet null we will compare and pick which one is smaller 
            // to be added to the output 
            while(l1 != null & l2 != null)
            {
                int val1 = l1.val;
                int val2 = l2.val;

                // val1 is smaller hence we take l1
                if(val1 < val2)
                {
                    if(output == null)
                    {
                        output = l1;
                        currPointer = l1;

                        // We also have to increment l1
                        l1 = l1.next;
                    }
                    else
                    {
                        // If we are here then that means output already took the first value
                        // we have to set currPointer's next to l1
                        currPointer.next = l1;

                        currPointer = currPointer.next;

                        // Then we increment l1
                        l1 = l1.next;
                    }
                }
                // val2 is smaller hence we take l2
                else
                {
                    if(output == null)
                    {
                        output = l2;
                        currPointer = l2;

                        // Increement l2
                        l2 = l2.next;
                    }
                    else
                    {
                        currPointer.next = l2;

                        currPointer = currPointer.next;

                        // Then we increment l2
                        l2 = l2.next;
                    }
                }
            }

            // We have to keep in mind that we could be always taking from the
            // first list or the second list and touched none of the other list
            // so we have just have to finish picking off the rest
            while(l1 != null)
            {
                currPointer.next = l1;

                currPointer = currPointer.next;

                l1 = l1.next;
            }

            while(l2 != null)
            {
                currPointer.next = l2;

                currPointer = currPointer.next;

                l2 = l2.next;
            }
        }
        return output;
    }
    
    /**
     * This function will take in k linked-lists all sorted in ascending order
     * and combine all k of the lists into one sorted linked-list and return it
     * 
     * @param lists
     * @return 
     */
    public static ListNode mergeKLists(ListNode lists[])
    {
        ListNode output = null;
        
        if(lists.length > 0)
        {
            output = lists[0];
        }
        
        for(int i=1;i<lists.length;i++)
        {
            output = mergeTwoLists(output, lists[i]);
        }
        
        return output;
    }
    
    static class ListNode
    {
        int val;
        ListNode next;
        
        public ListNode(int val)
        {
            this.val = val;
        }
    }
}