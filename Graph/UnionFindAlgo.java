public class UnionFindAlgo {
    int V;
    int E;
    Edge edge[];
    UnionFindAlgo(int v,int e) {
        V=v;E=e; 
        edge=new Edge[e];
        for(int i=0;i<E;i++){
            edge[i]=new Edge();
        }

    }
    class ParentRank{
        int parent;
        int rank;
    }
    class Edge{
        int src;
        int dest;
    };
    public  int findParent(ParentRank set[],int x){
        if(set[x].parent==x){
            return x;
        }
        return set[x].parent=findParent(set,set[x].parent);

    }
    public  void union(ParentRank set[],int p1,int p2){
        int x=findParent(set,p1);
        int y=findParent(set,p2);
        // int x=p1;
        // int y=p2;
        if(set[x].rank<set[y].rank){
            set[x].parent=y;
        }else if(set[x].rank>set[y].rank){
            set[y].parent=x;
        }else{
            set[x].parent=y;
            set[y].rank++;
        }
    }
    public  boolean detectCycle(int n){
        ParentRank set[]=new ParentRank[n];
        for(int i=0;i<V;i++){
            set[i]=new ParentRank();
            set[i].parent=i;
            set[i].rank=0;
        }
        for(int i=0;i<E;i++){
            int p1=findParent(set,edge[i].src);
            int p2=findParent(set,edge[i].dest);

            if(p1==p2){
                return true;
            }
            union(set,p1,p2);
        }
        return false;
    }
    public static void main(String[] args){
        int V=3;
        int E=2;
        UnionFindAlgo graph = new UnionFindAlgo(V,E);
        /* Let us create the following graph
        0
        | \
        |  \
        1---2 */
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
 
        // add edge 0-2
        graph.edge[2].src = 2;
        graph.edge[2].dest = 2;
        System.out.println(graph.detectCycle(V));

        
    }
}
