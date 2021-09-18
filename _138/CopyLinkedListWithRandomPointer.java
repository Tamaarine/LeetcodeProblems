package _138;

import java.util.HashMap;

public class CopyLinkedListWithRandomPointer {
    
    static class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public static void main(String[] args) {
        
    }
    
    public static Node copyRandomList(Node head) {
        // Use two hashmap, the first one maps the original node to an index
        // in which we can use to refer to the new nodes that we create later
        HashMap<Node, Integer> original = new HashMap<>();
        
        // This hashmap will map index to the next copy of nodes that we did
        HashMap<Integer, Node> newMap = new HashMap<>();
        
        // Need a dummynode to take out edge cases
        Node newRoot = new Node(4); // dummy node
        Node newCurr = newRoot;
        
        Node currPointer = head;
        int counter = 0; // Use to do the indexing
        
        while(currPointer != null) {
            // The temp node
            Node temp = new Node(currPointer.val);
            newCurr.next = temp;
            
            // Make the map
            original.put(currPointer, counter);
            newMap.put(counter, temp); // instead of putting newCurr because it will take the dummy node, we put temp
            
            currPointer = currPointer.next;
            newCurr = newCurr.next;
            counter++;
        }
        
        // Reset currPointer
        currPointer = head;
        newCurr = newRoot.next;
        
        // Go through it one more time to figure out the random nodes
        // using the two hashmap we have
        while(currPointer != null) {
            if(currPointer.random != null) {
                // get the originalIndex that the original pointer maps to
                int originalIndex = original.get(currPointer.random);
                newCurr.random = newMap.get(originalIndex); // then use the index to get the new node it is associated with it
                currPointer = currPointer.next;
                newCurr = newCurr.next;
            }
            else {
                currPointer = currPointer.next;
                newCurr = newCurr.next;
            }
        }
        
        // return the newroot without dummy node
        return newRoot.next;
    }
}
