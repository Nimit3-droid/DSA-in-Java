import java.util.*;
public class KahnTopoSort {
//     time Complexity: O(V+E). 
// The outer for loop will be executed V number
// of times and the inner for loop will be executed E number of times.
// Auxiliary Space: O(V). 
    public void addMinEdges(Queue<Integer> q,int arr[]){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=Integer.MAX_VALUE && arr[i]==0){
                arr[i]=Integer.MAX_VALUE;
                q.add(i);
            }
        }
    }
    public ArrayList<Integer> tpsort(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> ans= new ArrayList<>();
        Queue<Integer> q = new LinkedList<Integer>();
        int indegree[]=new int[adj.size()];
        for(int i=0; i<adj.size(); i++){
            for(int v:adj.get(i)){
                indegree[v]++;
            }
        }
        addMinEdges(q,indegree);
        while(!q.isEmpty()){
                int u=q.poll();
                ans.add(u);
                for(int neigh:adj.get(u)){
                    indegree[neigh]--;
                    if(indegree[neigh]==0) q.add(neigh);
                }

        } 
        return ans;
    }
}
