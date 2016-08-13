279. Perfect Squares  QuestionEditorial Solution  My Submissions
Total Accepted: 44742
Total Submissions: 131770
Difficulty: Medium
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.


public class Solution {
    public int numSquares(int n) { //can't get least num! 
        List<Integer> prfctNum = new ArrayList<Integer>();
        int i = 1;
        while(i *i <= n){
            prfctNum.add(i*i);
            i++;
        }
        
        Queue<Integer> nodes = new LinkedList<Integer>(); 
        Set<Integer> voidDup = new HashSet<Integer>(); //用一个set来去重，因为比如说4（4= 2+2），如果之后再出现（4= 1+1+1+1)，
        //就不用加到Queue, 避免memory exceed 
        
        
        nodes.offer(0); //initial node 

        int minstep = 0;  //initial level 
        while (nodes.size() > 0){
            minstep ++;  
            int stepsize = nodes.size();  //fixed at each level 
            for(int j =0; j<stepsize; j++){   // iterate at each level 
                int cursolution = nodes.poll();  //fixed at each level 
                for(int choice : prfctNum){ //expand all choices to each node in this level 
                    int solution = cursolution+ choice;  //update each node 
                    if(solution == n){
                        return minstep;
                    }
                    if (!voidDup.contains(solution)){ //用set 比直接在Q里找东西和用hashmap快
                    nodes.offer(solution); //at the new node(of next level to Q )
                    voidDup.add(solution); 
                    } 
  
                }
            }
        }
        return minstep;
        
    }
}
