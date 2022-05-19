import java.util.*;
public class topologicalSort{
//     Time Complexity: O(V+E). 
// The above algorithm is simply DFS with an extra stack. So time complexity is the same as DFS which is.
// Auxiliary space: O(V). 
// The extra space  is needed for the stack.
    public void dfs(ArrayList<ArrayList<Integer>> adj,int s,Stack<Integer> stack,boolean isVisited[]){
        isVisited[s]=true;
        Iterator<Integer> it=adj.get(s).iterator();
        while(it.hasNext()){
            int u=it.next();
            if(!isVisited[u]){
                dfs(adj,u,stack,isVisited);
            }
        }
        stack.push(s);
    }
    public Stack<Integer> Tpsort(ArrayList<ArrayList<Integer>> adj)  {
        Stack<Integer> stack = new Stack<Integer>();
        boolean isVisited[]=new boolean[adj.size()];
        for(int i=0; i<adj.size(); i++){
            if(!isVisited[i]){
                dfs(adj,i,stack,isVisited);
            }
        }
        return stack;
        
    }
    
}