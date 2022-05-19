// package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class edge_cut_algo {
    public void dfs(ArrayList<ArrayList<Integer>> adj , int n){
        int timer=0;
        int dis[]=new int[n];
        int low[]=new int[n];
        Arrays.fill(dis,-1);
        Arrays.fill(low, -1);
        for(int i=0;i<n;i++){
            if(dis[i]==-1){
                dfsUtil(adj, i,-1, dis,   low, timer);
            }
        }
    }
    
    public void dfsUtil(ArrayList<ArrayList<Integer>> adj,int i,int parent, int dis[],  int low[],int timer) {
        dis[i]=timer;
        low[i]=timer;
        
        timer++;
        for(int it:adj.get(i)){
            if(it==parent) continue;
            if(dis[it]==-1){
                dfsUtil(adj, it, i, dis, low, timer);
                low[i]=Math.min(low[i], low[it]);
                if(low[it]>dis[i]) System.out.println(it+ " ->  " + i);
            }else{
                low[i]=Math.min(low[i], dis[it]);
            }
        }

    }
}
