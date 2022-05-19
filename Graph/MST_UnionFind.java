import java.util.*;
public class MST_UnionFind {
    public static int find(int x,int parent[]){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x],parent);
    }

    public static void union(int x,int y, int parent[],int rank[]){
        x=find(x,parent);
        y=find(y,parent);
        if(rank[x]<rank[y]){
            parent[x]=y;
        }else if(rank[x]>rank[y]){
            parent[y]=x;
        }else{
            parent[y]=x;
            rank[x]++;
        }

    }
    public static int mst(int n, ArrayList<ArrayList<Integer>> adj){
        ArrayList<ArrayList<Integer>> mst=new ArrayList<>();
        Collections.sort(adj,new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                return a.get(2)-b.get(2);
            }
        });
        int parent[]=new int[n];
        int rank[]=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        int edge=0;
        int cost=0;
        int i=0;
        while(edge<n-1 && i<adj.size()){
            ArrayList<Integer> curr=adj.get(i);
            int x=find(curr.get(0)-1,parent );
            int y=find(curr.get(1)-1,parent );
            if(x!=y){
                mst.add(curr);
                cost+=curr.get(2);
                union(x, y,parent, rank);
                edge++;
            }
            i++;

        }
        System.out.println(mst);
        return cost;
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> curr=new ArrayList<>();
            int m=sc.nextInt();
            for(int j=0;j<m;j++){
                int x=sc.nextInt();
                curr.add(x);
            }
            adj.add(curr);
        }
        System.out.println(mst(n,adj));
    }
}
