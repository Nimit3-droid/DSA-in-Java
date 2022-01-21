// package Graph;

import java.util.*;

public class Tarjans_strongly_connected_components_algorithm {
    public void dfs(ArrayList<ArrayList<Integer>> adj,int n){
        int dis[]=new int[n];
        Arrays.fill(dis,-1);
        int low[]=new int[n];
        Arrays.fill(low,-1);
        Stack<Integer> stack = new Stack<>();
        boolean isInStack[]=new boolean[n];
        int timer=0;
        for(int i=0;i<n;i++){
            if(dis[i]==-1){
                dfsUtil(adj,i,dis,low,isInStack,stack,timer);
            }
        }

    }
    public void dfsUtil(ArrayList<ArrayList<Integer>> adj,int i,int dis[],int low[],boolean isInStack[],Stack<Integer> stack ,int timer){
        dis[i]=timer;
        low[i]=timer;
        isInStack[i]=true;
        stack.push(i);
        timer++;
        for(int it:adj.get(i)){
            if(dis[it]==-1){
                dfsUtil(adj, it, dis, low, isInStack,stack, timer);
                low[i]=Math.min(low[i], low[it]);
            }else if(isInStack[it]){
                
                low[i]=Math.min(low[i], dis[it]);
            }
        }

        if(dis[i]==low[i]){
            System.out.print("SCC : ");
            while(stack.peek()!=i){
                isInStack[stack.peek()]=false;
                System.out.print(stack.pop()+" -> ");
            }
            isInStack[stack.peek()]=false;
            System.out.println(stack.pop());
        }
    }
}
