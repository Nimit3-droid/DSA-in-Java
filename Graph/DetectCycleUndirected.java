import java.util.*;
public class DetectCycleUndirected {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int n){
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(dfsutill(adj,visited,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfsutill(ArrayList<ArrayList<Integer>> adj,boolean visited[],int i,int parent){
        visited[i] = true;
        ArrayList<Integer> list = adj.get(i);
        for(int x : list){
            if(!visited[x]){
                if(dfsutill(adj,visited,x,i)){
                    return true;
                }
            }else if(x!=parent){
                return true;
            }
        }
        return false;

    }
}
