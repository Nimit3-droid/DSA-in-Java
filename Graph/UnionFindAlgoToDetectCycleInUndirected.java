public class UnionFindAlgoToDetectCycleInUndirected {
    public int Findparent(int parent[],int v) {
        if(parent[v]==-1){
            return v;
        }
        return Findparent(parent,parent[v]);
    }
    public void union(int parent[],int v1,int v2){
        parent[v1]=v2;
    }
    public boolean detectCycle(Edges[] graph,int V,int E) {
        int parent[]=new int[V];
        for(int i=0;i<V;i++) parent[i]=-1;
        for(int i=0;i<E;i++){
            int v1=Findparent(parent,graph[i].src);
            int v2=Findparent(parent,graph[i].dest);
            if(v1==v2){
                return true;
            }
            union(parent,v1,v2);
        }
        return false;
    }

    
}
