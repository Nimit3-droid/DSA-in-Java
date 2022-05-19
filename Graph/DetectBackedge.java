
import java.util.*;

public class DetectBackedge {
    //it detectCycle in directed graph
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int n){
        boolean visited[]=new boolean[n];

        boolean recursionStack[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(dfsutil(adj,visited,recursionStack,i)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfsutil(ArrayList<ArrayList<Integer>> adj,boolean visited[],boolean recursionStack[], int i){
        //true=>cycle.
        //if a visited node is already present in recursion stack it means we hava a back edge => cycle
        if(recursionStack[i]==true){
            return true;
        }
        if(visited[i]==true){
            return false;
        }
        visited[i]=true;
        recursionStack[i]=true;
        ArrayList<Integer> list=adj.get(i);
        for(int x:list){
            if(dfsutil(adj,visited,recursionStack,x)==true){
                return true;
            }
        }
        recursionStack[i]=false;
        return false;
    }
    
}
