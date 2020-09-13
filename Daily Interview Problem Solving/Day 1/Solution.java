import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    public boolean solve(Tree root, Tree target) {
        // Write your code here
        if(root == null && target == null) return true;
        if(root == null || target == null) return false;
        
        if(root.val == target.val){
            return solve(root.left,target.left) && solve(root.right,target.right);
        }
        else{
            return solve(root.left,target) || solve(root.right,target);
        }
    }
}
