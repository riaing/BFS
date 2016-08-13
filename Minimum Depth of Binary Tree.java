public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null ){
            return 0; 
        }
        
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.offer(root); 
        
        int minDepth = 0;
        while(nodes.size() != 0){
            minDepth++; 
            int levelSize = 0;
            for(int i = 0; i< levelSize; i ++){  // 超时
                TreeNode cur = nodes.poll();
                if(cur.left== null && cur.right == null){
                    return minDepth;
                }
                
                if(cur.left != null){
                    nodes.offer( cur.left);
                }
                if(cur.right != null){
                    nodes.offer(cur.right);
                }
            }
                
            
        }
        return 0;

  }
}

---------------未超时，避免使用了for loop， 用一个变量 lastNum来代表当层节点数，curNum来计算下一层节点数

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
    public int minDepth(TreeNode root) {
        if(root == null ){
            return 0; 
        }
        
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.offer(root); 
        int curNum = 0; //the cur elemnt in this level 
        int lastNum = 1; //total element in this level 
        
        int minDepth = 1; //变为了1 
        while(nodes.size() != 0){
           

            
                TreeNode cur = nodes.poll();
                lastNum --; 
                
                if(cur.left== null && cur.right == null){
                    return minDepth;
                }
                
                if(cur.left != null){
                    nodes.offer( cur.left);
                    curNum++;
                }
                if(cur.right != null){
                    nodes.offer(cur.right);
                    curNum ++; 
                }
                
                if(lastNum ==0){ //end of this level
                 minDepth++; 
                 lastNum =curNum; //how many element in the new level 
                 curNum = 0; // 复原
                }
        }
        return 0;
        
    
    }    


}
