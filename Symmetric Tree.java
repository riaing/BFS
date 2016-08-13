/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();  //得用两个Q分别存
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.offer(root.left);
        q2.offer(root.right); 
        
        while(q1.size() != 0 && q2.size() != 0){
            TreeNode t1 =q1.poll();
            TreeNode t2 = q2.poll(); 
            
            if(t1 ==null && t2 != null){
                return false;
            }
            if(t1 != null && t2 == null){
                return false; 
            }
            if(t1 != null && t2 !=null){
                if(t1.val != t2.val){
                    return false; 
                }
                q1.offer(t1.left); //这里左边的q添加从左到右
                q1.offer(t1.right);
                q2.offer(t2.right); //右边的q添加从右到左。顺序不可反
                q2.offer(t2.left); 
            }
        }
        
        if(q1.size() != 0 || q2.size() != 0){
            return false;
        }
        return true; 
        
     } 
}
