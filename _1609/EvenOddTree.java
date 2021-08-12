package _1609;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(10);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(12);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(6);
        TreeNode n10 = new TreeNode(2);
        
        n1.left = n2;
        n1.right = n3;
        
        n2.left = n4;
        
        n4.left = n7;
        n4.right = n8;
        
        n3.left = n5;
        n3.right = n6;
        
        n5.left = n9;
        
        n6.right = n10;
        
        System.out.println(isEvenOddTree(n1));
    }
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> dequeued = new ArrayList<>();
        int childLeftToConsume = 1; // child left to consume for the current level
        int childCount = 0; // child count for the next level
        int level = 0;
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            childLeftToConsume--;
            TreeNode temp = queue.poll();
            dequeued.add(temp);
            
            if(temp.left != null) {
                queue.add(temp.left);
                childCount++;
            }
            
            if(temp.right != null) {
                queue.add(temp.right);
                childCount++;
            }
            
            if(childLeftToConsume == 0) {
                // Go through dequeded arraylist to make sure it follow what the level is specified to
                if(level % 2 == 0) {
                    // even, all element must be odd and be increasing order
                    for(int i=0;i<dequeued.size();i++) {
                        int current = dequeued.get(i).val;
                        if(current % 2 != 1) return false;
                        if(i > 0 && current >= dequeued.get(i - 1).val) return false;
                    }
                }
                else {
                    // odd, all element must be even and be decreasing order
                    for(int i=0;i<dequeued.size()-1;i++) {
                        int current = dequeued.get(i).val;
                        if(current % 2 != 0) return false;
                        if(i > 0 && current <= dequeued.get(i - 1).val) return false;
                    }
                }
                dequeued.clear(); // need to clear the arraylist
                level++;
                childLeftToConsume = childCount;
                childCount = 0;
            }
        }
        return true;
    }
}
