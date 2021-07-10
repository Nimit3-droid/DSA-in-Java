package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class kosaraju_strongly_connected_components_algorithm {
    public void dfs(ArrayList<ArrayList<Integer>> adj,int n){
        Stack<Integer> tps=new Stack<>();
        boolean isvisited[]=new boolean[n];
        for(int i =0;i<n;i++){
            if(!isvisited[i]){
                dfsutil(i,adj,isvisited,tps);
            }
        }
        Arrays.fill(isvisited,false);
        ArrayList<ArrayList<Integer>> transpose=new ArrayList<>();

        for (int i = 0; i < n; i++) 
			transpose.add(new ArrayList<Integer>());

		for(int i = 0;i<n;i++) {
			for(Integer it: adj.get(i)) {
				transpose.get(it).add(i); 
			}
		}
        while(!tps.isEmpty()){
            int popped=tps.pop();
            if(!isvisited[popped]){
                System.out.print("SCC : ");
                dfsREV(popped, isvisited, transpose);
                System.out.println();
            }
        }
    }

    private void dfsREV(int i, boolean[] isvisited, ArrayList<ArrayList<Integer>> transpose) {
        isvisited[i]=true;
        System.out.print(i+" -> ");
        for(int it:transpose.get(i)){
            if(!isvisited[it]){
                dfsREV(it, isvisited, transpose);
            }
        }
    }

    private void dfsutil(int i,ArrayList<ArrayList<Integer>> adj, boolean[] isvisited, Stack<Integer> tps) {
        isvisited[i]=true;
        for(int it : adj.get(i)){
            if(!isvisited[it]){
                dfsutil(it,adj,isvisited,tps);
            }
        }
        tps.push(i);
    }
}
