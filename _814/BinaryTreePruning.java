package _814;

public class BinaryTreePruning {
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static TreeNode pruneTree(TreeNode root) {
        boolean ans = helper(root);
        if(!ans) return null; // the subtree is not valid at all
        else return root;

    }
    
    public static boolean helper(TreeNode node) {
        if(node == null) return false; // leaf node's child just return false
        else {
            boolean left = helper(node.left);
            boolean right = helper(node.right);
            
            if(!left && !right) {
                if(node.val == 1) {
                    node.left = null;
                    node.right = null;
                    return true;
                }
                else {
                    return false;
                }
            }
            else if(!left) {
                // delete left child and return  true
                node.left = null; 
            }
            else if(!right) {
                node.right = null;
            }
            
            // After fixing the current node, we can return true here
            // if either one of the child exist and is true
            return true;
            
        }
    }
}
