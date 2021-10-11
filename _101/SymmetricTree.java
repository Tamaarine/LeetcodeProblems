package _101;

import java.util.List;
import java.util.ArrayList;

public class SymmetricTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        
        TreeNode(int val) { this.val = val; }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
    }
    
    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<>();
    }
    
    public static boolean isSymmetric(TreeNode root) {
        List<TreeNode> lists = new ArrayList<>();
        lists.add(root);
        
        return helper(root, lists, 1);
    }
    
    public static boolean helper(TreeNode node, List<TreeNode> nodes, int childCount) {
        if(nodes.size() == 0) {
            return true; // If size is 0 then it is valid
        }
        
        TreeNode removed = nodes.remove(0);
        childCount -= 1;
        
        if(removed != null) {
            if(removed.left != null) 
            {
                nodes.add(removed.left);
            }
            else {
                nodes.add(null);
            }
            
            if(removed.right != null)
            {
                nodes.add(removed.right);
            }
            else {
                nodes.add(null);
            }            
        }
        
        if(nodes.size() == 0) {
            return true; // If size is 0 then it is valid
        }
        
        if(childCount == 0) {
            // Do the mirror check here with the list
            int size = nodes.size();
            for(int i=0;i<size / 2;i++) {
                TreeNode nodei = nodes.get(i);
                TreeNode nodeiback = nodes.get(size - i - 1);

                // If both null then is fine, no need to check value
                if(nodei == null && nodeiback == null) {
                    continue;
                }
                else if(nodei != null && nodeiback != null) {
                    // check value
                    if(nodes.get(i).val != nodes.get(size - i - 1).val) {
                        return false;
                    }
                }
                // one of them is not null return false
                else {
                    return false;
                }
            }
            // Reset childCount
            childCount = size;    
        }

        return helper(nodes.get(0), nodes, childCount);
    }
}
