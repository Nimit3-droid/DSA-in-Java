
import java.util.*;

public class ArticulationPointUsingTarjansAlgo {
    public void dfs(ArrayList<ArrayList<Integer>> adj,int n){
        int dis[]=new int[n];
        int low[]=new int[n];
        Arrays.fill(dis,-1);
        Arrays.fill(low,-1);
        boolean Ap[]=new boolean[n];
        int timer=0;
        for(int i=0;i<n;i++){
            if(dis[i]==-1){
                dfsUtil(i,-1, adj,timer,dis,low,Ap);
            }
        }
        for(int i=0;i<n;i++){
            if(Ap[i]){
                System.out.print(i+"  ");
            }
        }
        System.out.println();
    }
    private void dfsUtil(int i,int parent, ArrayList<ArrayList<Integer>> adj, int timer, int[] dis, int[] low, boolean[] ap) {
        dis[i]=timer;
        low[i]=timer;
        timer++;
        int children=0;
        for(int it : adj.get(i)){
            if(it==parent) continue;
            if(dis[it]==-1){
                dfsUtil(it, i, adj, timer, dis, low, ap);
                children++;
                low[i]=Math.min(low[i], low[it]);
                //if root node 
                if(parent==-1 && children>1) ap[i]=true;
                //if not root node
                if(parent!=-1 && low[it]>=dis[i]) ap[i]=true;
            }else{
                low[i]=Math.min(low[i], dis[it]);
            }
        }
    }
}
