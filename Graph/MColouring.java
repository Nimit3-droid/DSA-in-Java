import java.util.*;
public class MColouring {
    public boolean isValid(int node,int[] color,ArrayList<ArrayList<Integer>> adj,int m){
        for(int x:adj.get(node)){
            if(color[x]==m){
                return false;
            }
        }
        return true;
    }
    public boolean mColor(int node,ArrayList<ArrayList<Integer>> adj,int n,int m,int[] color){
        if(node==n) return true;
        for(int i=1;i<=m;i++){
            if(color[node]==0 && isValid(node,color,adj,i)){
                color[node]=i;
                if(mColor(node+1,adj,n,m,color)) return true;
                color[node]=0;
            }
        }
        return false;

    }
}
